val l =List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))

//28 a)
val x = l.sortBy(e=> e.length)
val x1 = l.sortBy(e=> e.length).map(d => d.length)



//28 b)
val j = l.sortBy(e=> e.length).map(d => (d.length,d))

j.sortBy(e=>e._1)
val d=j.groupBy(_._1).map( f => (f._1,f._2.length,f._2)).toList
d.sortBy(_._2).map(_._3).map(f=)

j.groupBy(_._1).foreach( ob => println(ob._1))






val f = List(1, 2, 3, 2, 1)

f.sorted