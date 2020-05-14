package problems;

// 约瑟环问题
public class TestComConne {

    public static void main(String[] args) {
        Boolean[] usaJapa = new Boolean[30];
        for (int i = 0; i < usaJapa.length; i++)// 初始化数组元素，true表示没有被扔下海
            usaJapa[i] = true;

        int leftCount = usaJapa.length;// 从左向右开始数,剩下的人数
        int po = 0;// 数组下标
        int countNum = 0;
        int index = 0;// 数到的人数
        int lost = 0;// 被扔下海的人数
        boolean isTrue = true;// 是否被扔下海，true代表没有被扔下海

        while (leftCount > 15) {
            if (lost < 15) {
                countNum++;// 从1-9循环计数，第九个人被扔下海
                if (countNum == 9 && usaJapa[po] == true) {
                    countNum = 0;// 重新从0开始计数
                    usaJapa[po] = false;// 被扔下海后，将值变成false
                    leftCount--;// 总数量减一
                    lost++;// 被扔下海的人数加一
                    index++;
                    po++;
                } else if (countNum == 9 && usaJapa[po] == false) {
                    while (isTrue && po < 29) {
                        if (usaJapa[po + 1] == true) {
                            countNum = 0;// 重新从0开始计数
                            usaJapa[po + 1] = false;// 被扔下海后，将值变成false
                            leftCount--;// 总数量减一
                            lost++;// 被扔下海的人数加一
                            index++;
                            isTrue = false;// 找到被扔下海的人
                            po++;
                        } else {
                            index++;
                            po++;
                        }
                    }
                } else {
                    int isZero = 0;
                    if (po < 30) {
                        while (usaJapa[po] == false) {
                            isZero++;
                            countNum += isZero;
                            countNum--;
                            if (countNum >= 9)
                                countNum = 0;
                            index++;
                            po++;
                            if (po == 30)
                                po = 0;
                        }
                        if (usaJapa[po]) {
                            countNum -= isZero;
                            if (isZero == 0)
                                index++;
                            po -= isZero;
                            po++;
                            if (po == 30)
                                po = 0;
                        }
                    } else
                        po = 0;
                }
                if (index == usaJapa.length) {
                    for (int i = 0; i < usaJapa.length; i++)
                        System.out.println(i + "=" + usaJapa[i] + " ");
                    index = 0;
                }
            } else {
                System.out.println("船上已经只有15人，可以安全逃离！");
            }
        }
        for (int i = 0; i < usaJapa.length; i++)
            System.out.println(i + "=" + usaJapa[i] + " ");
    }

}