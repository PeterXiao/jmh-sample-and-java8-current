/**
 * @author xiaoy
 * @date 2020/05/23
 */
package compareuntil.eclipsecollections;
/*


var people = List.of(new Person("Alice", 19),
new Person("Bob", 52), new Person("Carol", 35));

var namesOver21 = people.stream()               // Bun
       .filter(person -> person.getAge() > 21)  // Meat
       .map(Person::getName)                    // Meat
       .collect(Collectors.toList());           // Bun

namesOver21.forEach(System.out::println);


@Test
public void countJdkNaive()
{
    Map<String, Integer> wordCount = new HashMap<>();

    words.forEach(w -> {
        int count = wordCount.getOrDefault(w, 0);
        count++;
        wordCount.put(w, count);
    });

    System.out.println(wordCount);

    Assert.assertEquals(2, wordCount.get(“Bah”).intValue());
    Assert.assertEquals(1, wordCount.get(“sheep”).intValue());
}

@Test
public void countJdkStream()
{
   Map<String, Long> wordCounts = words.stream()
           .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
   Assert.assertEquals(2, wordCounts.get(“Bah”).intValue());
   Assert.assertEquals(1, wordCounts.get(“sheep”).intValue());
}


@Test
public void countJdkEfficient()
{
   Map<String, Counter> wordCounts = new HashMap<>();

   words.forEach(
     w -> {
        Counter counter = wordCounts.computeIfAbsent(w, x -> new Counter());
               counter.increment();
     }
   );

   Assert.assertEquals(2, wordCounts.get(“Bah”).intValue());
   Assert.assertEquals(1, wordCounts.get(“sheep”).intValue());
}


    @Test
    public void countEc()
    {
        Bag<String> bagOfWords = wordList.toBag();
            // toBag() is a method on MutableList

        Assert.assertEquals(2, bagOfWords.occurrencesOf(“Bah”));
        Assert.assertEquals(1, bagOfWords.occurrencesOf(“sheep”));
        Assert.assertEquals(0, bagOfWords.occurrencesOf(“Cheburashka”));
            // null safe - returns a zero instead of throwing an NPE
    }
    
    
*/