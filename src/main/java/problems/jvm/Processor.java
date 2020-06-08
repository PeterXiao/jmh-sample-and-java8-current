/**
 * 
 */
package problems.jvm;

/**
 * @author xiaoy
 *
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//窗口界面
public class Processor extends JFrame implements Runnable{
    JTable jTable;
    DefaultTableModel tableModel;  //表格的模式，用于添加和删除
    private JPanel jPanel_addProcess=new JPanel();

    private JLabel jLabel_processName=new JLabel("进程名");
    private JLabel jLabel_processTime=new JLabel("运行时间");
    private JLabel jLabel_memorySize=new JLabel("内存大小");
    private JLabel jLabel_priority=new JLabel("优先权");
    private JLabel jLabel_preID=new JLabel("前驱(无则为0)");
    private JLabel jLabel_nextID=new JLabel("后继(无则为0)");

    private JTextField jtf_processName=new JTextField(4);
    private JTextField jtf_processTime=new JTextField(4);
    private JTextField jtf_memorySize=new JTextField(4);
    private JTextField jtf_priority=new JTextField(4);
    private JTextField jtf_preID=new JTextField(4);
    private JTextField jtf_nextID=new JTextField(4);
    private JButton jButton_addProcess=new JButton("添加进程");

    private JLabel jLabel_backUp=new JLabel("后备队列");
    private JLabel jLabel_ready=new JLabel("就绪队列");
    private JLabel jLabel_suspend=new JLabel("挂起进程");
    private JLabel jLabel_finish=new JLabel("已完成的进程");
    private JLabel jLabel_pathNum=new JLabel("道数: 4");
    private JButton jButton_backUp=new JButton("加入就绪队列");
    private JButton jButton_ready=new JButton("运行");
    private JButton jButton_suspend=new JButton("挂起");
    private JButton jButton_wakeUp=new JButton("解挂");

    //所有的进程
    ArrayList <PCB> process_list=new ArrayList<PCB>();
    //后备队列中的进程
    ArrayList <PCB> backUp_list =new ArrayList<PCB>();
    //就绪队列中的进程
    ArrayList <PCB> ready_list=new ArrayList<PCB>();
    //挂起的进程
    ArrayList <PCB> suspend_list=new ArrayList<PCB>();
    //已完成的进程
    ArrayList <PCB> finish_list=new ArrayList<PCB>();
    //内存队列
    ArrayList <Memory> memory_list=new ArrayList<Memory>();

    private JPanel jPanel_process1=new JPanel();
    private JPanel jPanel_process2=new JPanel();
    private JLabel jLabel_process1=new JLabel("处理机1");
    private JLabel jLabel_process2=new JLabel("处理机2");

    private JPanel jPanelBackUp1=new JPanel();
    JTable jTable_backUp;
    DefaultTableModel tableModel_backUp;  //表格的模式，用于添加和删除
    JTable jTable_ready;
    DefaultTableModel tableModel_ready;
    JTable jTable_suspend;
    DefaultTableModel tableModel_suspend;
    JTable jTable_finish;
    DefaultTableModel tableModel_finish;
    JTable jTable_process1;
    DefaultTableModel tableModel_processor1;
    JTable jTable_process2;
    DefaultTableModel tableModel_processor2;

    private JButton jButton_test=new JButton("测试");
    Comparator cmp=new Priority_comparator();


    public Processor(){
        this.setTitle("Multi-Processor-Scheduling");
        //this.setLocationRelativeTo(null);   //居中显示
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBounds(200,100,1000,700);
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        jLabel_backUp.setFont(new Font("楷体", Font.BOLD, 20));
        jLabel_ready.setFont(new Font("楷体", Font.BOLD, 20));
        jLabel_suspend.setFont(new Font("楷体", Font.BOLD, 20));
        jLabel_finish.setFont(new Font("楷体", Font.BOLD, 20));
        this.add(jLabel_pathNum); jLabel_pathNum.setBounds(550,200,100,30);
        jLabel_pathNum.setFont(new Font("黑体", Font.BOLD, 20));

        //1.空闲分区表的设置
        JLabel jl_vacant=new JLabel("空闲分区表");
        this.add(jl_vacant);
        jl_vacant.setFont(new Font("楷体", Font.BOLD, 20));
        jl_vacant.setBounds(810,20,150,30);
        String[][] data = {};
        memory_list.add(new Memory(20,50));
        memory_list.add(new Memory(80,32));
        memory_list.add(new Memory(120,110));
        memory_list.add(new Memory(280,50));
        memory_list.add(new Memory(400,75));
        // Column Names
        String[] columnNames = { "基址", "长度","分配状态" };
        // Initializing the JTable
        tableModel = new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;         //设置为不可编辑
            }
        };
        updateMemory();
        //jTable = new JTable(data, columnNames);
        jTable=new JTable(tableModel);
        JScrollPane sp = new JScrollPane(jTable);
        this.add(sp);
        sp.setBounds(760,50,200,175);
        //jTable.setBounds(20, 20, 250, 300);
        jTable.setRowHeight(30);
        //tableModel.addRow(new String[]{"C", "56", "80"});

        //2.添加进程
        this.add(jPanel_addProcess);
        jPanel_addProcess.setBounds(10,0,680,90);
        jPanel_addProcess.setBackground(Color.white);
        jPanel_addProcess.setLayout(new GridLayout(1,4,10,5));

        jPanel_addProcess.add(jLabel_processName); jLabel_processName.setBounds(0,0,50,30);
        jPanel_addProcess.add(jLabel_processTime); jLabel_processTime.setBounds(80,0,50,30);
        jPanel_addProcess.add(jLabel_memorySize);  jLabel_memorySize.setBounds(160,0,50,30);
        jPanel_addProcess.add(jLabel_priority);    jLabel_priority.setBounds(240,0,50,30);
        jPanel_addProcess.add(jLabel_preID);       jLabel_preID.setBounds(320,0,80,30);
        jPanel_addProcess.add(jLabel_nextID);      jLabel_nextID.setBounds(430,0,80,30);

        jPanel_addProcess.add(jtf_processName);  jtf_processName.setBounds(0,40,50,30);
        jPanel_addProcess.add(jtf_processTime);  jtf_processTime.setBounds(80,40,50,30);
        jPanel_addProcess.add(jtf_memorySize);   jtf_memorySize.setBounds(160,40,50,30);
        jPanel_addProcess.add(jtf_priority);     jtf_priority.setBounds(240,40,50,30);
        jPanel_addProcess.add(jtf_preID);        jtf_preID.setBounds(320,40,80,30);
        jPanel_addProcess.add(jtf_nextID);       jtf_nextID.setBounds(430,40,80,30);
        jtf_preID.setText("0");  jtf_nextID.setText("0");
        jtf_processName.setText("1"); jtf_processTime.setText("2");
        jtf_memorySize.setText("20"); jtf_priority.setText("6");
        jPanel_addProcess.add(jButton_addProcess);
        jButton_addProcess.setBounds(550,30,90,40);


        this.add(jLabel_backUp);  jLabel_backUp.setBounds(30,90,100,30);
        String[][] data1 = {
                { null, null,null }
        };
        // Column Names
        String[] columnNames1 = { "进程名", "运行时间","优先级", };
        tableModel_backUp=new DefaultTableModel(data1,columnNames1){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable_backUp=new JTable(tableModel_backUp);
        JScrollPane scrollPane=new JScrollPane(jTable_backUp);
        this.add(scrollPane);  scrollPane.setBounds(10,120,250,200);
        jTable_backUp.setRowHeight(35);
        this.add(jButton_backUp);  jButton_backUp.setBounds(30,330,140,30);
        jButton_backUp.setBackground(Color.black); jButton_backUp.setForeground(Color.white);
        tableModel_backUp.removeRow(0);


//        this.add(jPanel_ready);
//        jPanel_ready.setBounds(290,120,250,200);
//        jPanel_ready.setBackground(Color.CYAN);
        this.add(jLabel_ready);   jLabel_ready.setBounds(310,90,100,30);
        tableModel_ready=new DefaultTableModel(data1,columnNames1){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable_ready=new JTable(tableModel_ready);
        JScrollPane scrollPane1=new JScrollPane(jTable_ready);
        this.add(scrollPane1);  scrollPane1.setBounds(290,120,250,200);
        jTable_ready.setRowHeight(35);
        tableModel_ready.removeRow(0);
        this.add(jButton_ready); jButton_ready.setBounds(310,330,80,30);
        jButton_ready.setBackground(Color.black); jButton_ready.setForeground(Color.white);
        this.add(jButton_suspend); jButton_suspend.setBounds(420,330,80,30);
        jButton_suspend.setBackground(Color.black); jButton_suspend.setForeground(Color.white);


//        this.add(jPanel_suspend);
//        jPanel_suspend.setBounds(10,400,250,200);
//        jPanel_suspend.setBackground(Color.red);
        this.add(jLabel_suspend); jLabel_suspend.setBounds(30,370,100,30);
        tableModel_suspend=new DefaultTableModel(data1,columnNames1){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable_suspend=new JTable(tableModel_suspend);
        JScrollPane scrollPane2=new JScrollPane(jTable_suspend);
        this.add(scrollPane2); scrollPane2.setBounds(10,400,250,200);
        jTable_suspend.setRowHeight(35);
        this.add(jButton_wakeUp); jButton_wakeUp.setBounds(30,610,80,30);
        jButton_wakeUp.setBackground(Color.black); jButton_wakeUp.setForeground(Color.white);
        tableModel_suspend.removeRow(0);


        this.add(jLabel_finish); jLabel_finish.setBounds(310,370,140,30);
        String[] finishColumn={"进程名","内存大小"};
        tableModel_finish=new DefaultTableModel(data1,finishColumn){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable_finish=new JTable(tableModel_finish);
        JScrollPane scrollPane3=new JScrollPane(jTable_finish);
        this.add(scrollPane3);  scrollPane3.setBounds(290,400,200,200);
        jTable_finish.setRowHeight(35);
        tableModel_finish.removeRow(0);

        String[][] process_data={{null,null,null}};

//        this.add(jPanel_process1);
//        jPanel_process1.setBounds(560,320,250,50);
//        jPanel_process1.setBackground(Color.CYAN);
        this.add(jLabel_process1);  jLabel_process1.setBounds(780,295,100,30);
        tableModel_processor1 =new DefaultTableModel(process_data,columnNames1){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable_process1=new JTable(tableModel_processor1);
        JScrollPane scrollPane4=new JScrollPane(jTable_process1);
        this.add(scrollPane4);    scrollPane4.setBounds(700,320,250,50);
        jTable_process1.setRowHeight(35);

        this.add(jLabel_process2);  jLabel_process2.setBounds(780,375,100,30);
        tableModel_processor2 =new DefaultTableModel(process_data,columnNames1){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable_process2=new JTable(tableModel_processor2);
        JScrollPane scrollPane5=new JScrollPane(jTable_process2);
        this.add(scrollPane5);    scrollPane5.setBounds(700,400,250,50);
        jTable_process2.setRowHeight(35);

        this.add(jButton_test); jButton_test.setBounds(700,500,100,30);
        jButton_test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] s={"1","2","3"};
//                int c=jTable_backUp.getSelectedColumn();
//                int r=jTable_backUp.getSelectedRow();
//                tableModel_backUp.setValueAt(2,r,2);
//                tableModel_backUp.setValueAt(2,r,1);
//                tableModel_backUp.setValueAt(2,r,0);
                System.out.println(jTable_backUp.getSelectedRow());
            }
        });
        //添加进程响应事件
        jButton_addProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Name=jtf_processName.getText();
                String Time=jtf_processTime.getText();
                String Priority=jtf_priority.getText();
                System.out.println(Priority);
                int id=Integer.parseInt(Name);
                int time=Integer.parseInt(Time);
                int priority=Integer.parseInt(Priority);
                int size=Integer.parseInt(jtf_memorySize.getText());
                int pre=Integer.parseInt(jtf_preID.getText());
                int next=Integer.parseInt(jtf_nextID.getText());

                if (!isJoin(id)) {   //防止同一个名字的进程重复进入后备队列
                    PCB process1=new PCB(id,time,priority,size);
                    process_list.add(process1);            //加入“所有进程”集合
                    backUp_list.add(process1);             //加入到后备队列中
                    tableModel_backUp.addRow(new String[]{Name, Time, Priority});
                    if(pre!=0||next!=0){  //测试是否为同步进程
                        process1.preID=pre;  process1.nextID=next;
                        process1.attribute="同步";
                    }
                    else{
                        process1.attribute="独立";
                    }

                }else {
                    JOptionPane.showMessageDialog(null,
                            "该进程已进入！", "Error",JOptionPane.WARNING_MESSAGE);
                }


            }
        });
        //从后备队列加入就绪队列，按顺序加入，不需要调度算法.但在就绪队列需要sort
        jButton_backUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableModel_backUp.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,
                            "后备队列无进程可加入", "Error",JOptionPane.WARNING_MESSAGE);

                }
                else {
                    PCB pcb=backUp_list.get(0);

                    if(ready_list.size()>=4){  //道数为4，只能在就绪队列加入四个进程
                        JOptionPane.showMessageDialog(null,
                                "通道已满！", "Error",JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        //每次只加入队首元素
                        boolean isCompleted=false;
                        //前驱进程如果完成了的话，后继进程便可以运行
                        for (PCB o:finish_list){
                            if (o.processID==backUp_list.get(0).preID){
                                isCompleted=true;
                            }
                        }
                        if ((backUp_list.get(0).preID != 0)&&!isCompleted) {
                            JOptionPane.showMessageDialog(null,
                                    "该进程有前驱，无法执行！", "Error", JOptionPane.WARNING_MESSAGE);
                            backUp_list.remove(pcb);
                            backUp_list.add(pcb);
                            updateBackUp();
                        }else if (!isMemoryEnough(pcb)){  //看内存是否足够
                            JOptionPane.showMessageDialog(null,
                                    "内存空间不足！", "Error",JOptionPane.WARNING_MESSAGE);
                            backUp_list.remove(pcb);
                            backUp_list.add(pcb);
                            updateBackUp();
                        }
                        else {
                            ready_list.add(backUp_list.get(0));   //加入就绪队列
                            Collections.sort(ready_list, cmp);    //按自定义比较方式来排序
                            //更新就绪队列表
                            updateReady();

                            //更新后备队列表
                            backUp_list.remove(backUp_list.get(0));
                            updateBackUp();

                            //更新内存表
                            updateMemory();
                        }
                    }
                }
            }
        });

        //运行进程
        jButton_ready.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**有两个处理机，每次取前两个*/
                if (ready_list.size()>0) {
                    //第一个处理机
                    PCB p1 = ready_list.get(0);
                    p1.priority--;
                    p1.processTime--;
                    boolean isCompleted=false;
                    //就绪队列不会出现运行时间为0的情况，因为为1的时候已经处理了，如下
                    if (p1.processTime==0){  //如果运行完此次后运行时间为0，加入已完成进程
                        //释放内存
                        for (Memory m:memory_list){
                            if (p1.allocationBase==m.base){
                                m.allocation="未分配";
                                p1.allocationBase=-1;
                            }
                        }
                        updateMemory();
                        finish_list.add(p1);
                        String[] data1 = new String[]{String.valueOf(p1.processID),
                                 String.valueOf(p1.size)};
                        tableModel_finish.addRow(data1);
                        setProcessor(tableModel_processor1,p1);   //设置为0也可的
                        isCompleted=true;
                        //不能提前移出，否则处理机2会出问题
                        //ready_list.remove(p1);   //已经运行完毕，从就绪队列删除
                        //到最后再来更新就绪队列表
                    }else {
                        //设置处理机1
                        setProcessor(tableModel_processor1,p1);
                    }
                    //处理机2的进程处理
                    if (ready_list.size()>1) {
                        PCB p2 = ready_list.get(1);
                        p2.priority--;
                        p2.processTime--;
                        if (p2.processTime==0){     //如果运行完此次后运行时间为0，加入已完成进程
                            for (Memory m:memory_list){
                                if (p2.allocationBase==m.base){
                                    m.allocation="未分配";
                                    p2.allocationBase=-1;
                                }
                            }
                            updateMemory();
                            finish_list.add(p2);
                            String[] data2 = new String[]{String.valueOf(p2.processID),
                                    String.valueOf(p2.size)};
                            tableModel_finish.addRow(data2);
                            setProcessor(tableModel_processor2,p2);   //运行时间为0也可显示的
                            ready_list.remove(p2);   //已经运行完毕，从就绪队列删除
                            //到最后再来更新就绪队列表
                        }else {
                            //设置处理机2
                            setProcessor(tableModel_processor2,p2);
                        }
                    }
                    if (isCompleted){
                        ready_list.remove(p1);
                    }
                    updateReady();
                }
                else{
                    JOptionPane.showMessageDialog(null,
                            "就绪队列为空！", "Error",JOptionPane.WARNING_MESSAGE);

                }

            }
        });

        //挂起进程
        jButton_suspend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTable_ready.getSelectedRow()==-1){  //-1表示没有选
                    JOptionPane.showMessageDialog(null,
                            "请选择需要挂起的进程！", "Error！",JOptionPane.WARNING_MESSAGE);

                }else {
                    int row = jTable_ready.getSelectedRow();
                    PCB suspendProcess = ready_list.get(row);
                    ready_list.remove(row);
                    updateReady();
                    //释放内存
                    for (Memory m:memory_list){
                        if (suspendProcess.allocationBase==m.base){
                            m.allocation="未分配";
                            suspendProcess.allocationBase=-1;
                        }
                    }
                    updateMemory();

                    suspend_list.add(suspendProcess);
                    tableModel_suspend.setRowCount(0);     //清空挂起队列
                    for (PCB p : suspend_list) {
                        String[] data = new String[]{String.valueOf(p.processID),
                                String.valueOf(p.processTime), String.valueOf(p.priority)};
                        tableModel_suspend.addRow(data);
                    }
                }
            }
        });

        //解挂进程
        jButton_wakeUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = jTable_suspend.getSelectedRow();
                PCB wakeUpProcess = suspend_list.get(row);
                if (jTable_suspend.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(null,
                            "请选择需要解挂的进程！", "Error！",JOptionPane.WARNING_MESSAGE);
                }
                else if (tableModel_ready.getRowCount()==4){
                    JOptionPane.showMessageDialog(null,
                            "就绪队列道数已满！", "Error！",JOptionPane.WARNING_MESSAGE);
                }
                else if (!isMemoryEnough(wakeUpProcess)){
                    JOptionPane.showMessageDialog(null,
                            "内存空间不足，请等待！", "Error！",JOptionPane.WARNING_MESSAGE);
                }
                else {
                    suspend_list.remove(row);
                    ready_list.add(wakeUpProcess);
                    updateReady();
                    tableModel_suspend.setRowCount(0);     //清空挂起队列
                    for (PCB p : suspend_list) {
                        String[] data = new String[]{String.valueOf(p.processID),
                                String.valueOf(p.processTime), String.valueOf(p.priority)};
                        tableModel_suspend.addRow(data);
                    }

                    updateMemory();

                }
            }
        });

        IniBackForTest();
        //IniReadyForTest();

        new Thread(this).start();
    }

    //检测是否可自动将后备队列中的进程加入就绪队列
    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(2000);
            }catch (Exception e){}

            if(tableModel_backUp.getRowCount()>0&&ready_list.size()<4){
                boolean isCompleted=false;
                //前驱进程如果完成了的话，后继进程便可以运行
                for (PCB o:finish_list){
                    if (o.processID==backUp_list.get(0).preID){
                        isCompleted=true;
                    }
                }
                if ((backUp_list.get(0).preID != 0)&&!isCompleted) {
                    //如果有前驱并且前驱未完成则不用执行操作
                }else if (!isMemoryEnough(backUp_list.get(0))){
                    //如果内存空间不够也不需要加入
                    PCB p=backUp_list.get(0);
                    backUp_list.remove(p);
                    backUp_list.add(p);
                    updateBackUp();
                }
                else {
                    ready_list.add(backUp_list.get(0));  //加入就绪队列
                    Collections.sort(ready_list, cmp);    //按自定义比较方式来排序
                    //更新就绪队列表
                    updateReady();

                    //更新后备队列表
                    backUp_list.remove(backUp_list.get(0));
                    updateBackUp();

                    updateMemory();
                }
            }
        }
    }

    public void setProcessor(DefaultTableModel model,PCB p){
        model.setValueAt(String.valueOf(p.processID),0,0);
        model.setValueAt(String.valueOf(p.processTime),0,1);
        model.setValueAt(String.valueOf(p.priority),0,2);
    }

    public void IniReadyForTest(){
        ready_list.add(new PCB(1,4,7,20));
        ready_list.add(new PCB(2,5,5,90));
        ready_list.add(new PCB(3,5,4,12));
        for (PCB p:ready_list){
            process_list.add(p);
        }
        updateReady();
    }

    public void IniBackForTest(){
        backUp_list.add(new PCB(4,6,9,34));
        for (PCB p:backUp_list){
            process_list.add(p);
        }
        updateBackUp();
    }

    public void updateBackUp(){
        tableModel_backUp.setRowCount(0);     //清空就绪队列
        for (PCB p:backUp_list){
            String[] data=new String[]{String.valueOf(p.processID),
                    String.valueOf(p.processTime),String.valueOf(p.priority)};
            tableModel_backUp.addRow(data);
        }
    }

    public void updateReady(){
        tableModel_ready.setRowCount(0);     //清空就绪队列
        Collections.sort(ready_list,cmp);
        for (PCB p:ready_list){
            String[] data=new String[]{String.valueOf(p.processID),
                    String.valueOf(p.processTime),String.valueOf(p.priority)};
            tableModel_ready.addRow(data);
        }
    }

    public void updateMemory(){
        tableModel.setRowCount(0);
        for (Memory m:memory_list){
            String[] data=new String[]{String.valueOf(m.base),
                    String.valueOf(m.size),m.allocation};
            tableModel.addRow(data);
        }
    }

    public boolean isMemoryEnough(PCB p){
        for (Memory m:memory_list){
            if (m.size>=p.size&&m.allocation.equals("未分配")){
                m.allocation=String.valueOf(p.processID);
                p.allocationBase=m.base;
                return true;
            }
        }
        return false;
    }



    public boolean isJoin(int id){
        for (PCB o:process_list){
            if(o.processID==id)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Processor();
    }
}



class Priority_comparator implements Comparator{
    public int compare(Object a,Object b){
        PCB p1=(PCB) a;
        PCB p2=(PCB) b;
        if (p1.priority<p2.priority)
            return 1;
        else if (p1.priority==p2.priority)
            return 0;
        else
            return -1;
    }
}

class Memory{
    int base;
    int size;
    String allocation;

    public Memory(int base,int size){
        this.base=base;
        this.size=size;
        allocation="未分配";
    }
}

class PCB{
    int processID;
    int processTime;
    int workTIme;        //已经运行的时间
    int needTIme;        //还需要的时间
    int size;            //需要分配的空间大小

    int priority;
    String state;        //状态分为后备，就绪，挂起，运行和完成五种状态
    String attribute;    //表示独立还是同步（前驱和后继）
    int preID;           //前驱和后继进程，如果没有则等于0
    int nextID;

    int allocationBase;  //被分配到的内存基址,等于-1表示未分配

    public PCB(int ID,int processTime,int priority,int size){
        this.processID=ID;
        this.processTime=processTime;
        this.priority=priority;
        this.size=size;


        this.preID=0;
        this.nextID=0;
        this.allocationBase=-1;
    }
}
