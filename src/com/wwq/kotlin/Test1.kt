package com.wwq.kotlin

/**
 * Created by wwq on 2017/7/26.
 */

fun main(args: Array<String>) {
    //1.带有两个 Int 参数、返回 Int 的函数
    print("sum of 3 and 5 is ")
    println(sum1(3, 5))
    //2.将表达式作为函数体、返回值类型自动推断的函数
    println("sum of 19 and 23 is ${sum2(19, 23)}")
    //3.函数返回无意义的值
    printSum3(-1, 8)
    //4.Unit 返回类型可以省略
    printSum4(-1, 8)
    //5.一次赋值（只读） 的局部变量
    printSum5()
    //6.可变变量
    printSum6()
    //7.使用字符串模板
    printSum7()
    //8.使用条件表达式
    println("max of 0 and 42 is ${maxOf8(0, 42)}")
    //9.使用 if 作为表达式
    println("max of 0 and 42 is ${maxOf9(0, 42)}")
    //10.使用返回可空值的函数
    printProduct10("6", "7")
    printProduct10("a", "7")
    printProduct10("a", "b")
    //11.使用类型检测及自动类型转换
    print11()
    //12.使用类型检测及自动类型转换
    print12()
    //13.使用类型检测及自动类型转换
    print13()
    //14.使用 for 循环
    print14()
    //15.使用 for 循环
    print15()
    //16.使用 while 循环
    print16()
    //17.使用 while 循环
    print17()
    //18.使用 in 运算符来检测某个数字是否在指定区间内
    print18()
    //19.检测某个数字是否在指定区间外
    print19()
    //20.区间迭代
    print20()
    //21.数列迭代
    print21()
    //22.对集合进行迭代
    print22()
    //23.使用 in 运算符来判断集合内是否包含某实例
    print23()
    //24.使用 lambda 表达式来过滤（filter） 和映射（map） 集合
    print24()
}

//1.带有两个 Int 参数、返回 Int 的函数
fun sum1(a: Int, b: Int): Int {
    return a + b
}

//2.将表达式作为函数体、返回值类型自动推断的函数
fun sum2(a: Int, b: Int) = a + b

//3.函数返回无意义的值
fun printSum3(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

//4.Unit 返回类型可以省略
fun printSum4(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

//5.一次赋值（只读） 的局部变量
fun printSum5() {
    val a: Int = 1 // 立即赋值
    val b = 2 // 自动推断出 `Int` 类型
    val c: Int // 如果没有初始值类型不能省略
    c = 3 // 明确赋值
    println("a = $a, b = $b, c = $c")
}

//6.可变变量
fun printSum6() {
    var x = 5 // 自动推断出 `Int` 类型
    x += 1
    println("x = $x")
}

//7.使用字符串模板
fun printSum7() {
    var a = 1
    // 模板中的简单名称：
    val s1 = "a is $a"
    a = 2
    // 模板中的任意表达式：
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}

//8.使用条件表达式
fun maxOf8(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

//9.使用 if 作为表达式
fun maxOf9(a: Int, b: Int) = if (a > b) a else b

//10.使用返回可空值的函数
fun printProduct10(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
// 直接使用 `x * y` 可能会报错，因为他们可能为 null
    if (x != null && y != null) {
// 在空检测后，x 和 y 会自动转换为非空值（non-nullable）
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun parseInt(str: String): Int? {
    //没有此函数，不知道为什么
//    return str.toIntOrNull()
    try {
        return str.toInt()
    } catch(e: Exception) {
        return 1
    }
}

//11.使用类型检测及自动类型转换
fun getStringLength11(obj: Any): Int? {
    if (obj is String) {
        // `obj` 在该条件分支内自动转换成 `String`
        return obj.length
    }
    // 在离开类型检测分支后，`obj` 仍然是 `Any` 类型
    return null
}

fun print11() {
    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength11(obj) ?: "... err, not a str ing"} ")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))
}

//12.使用类型检测及自动类型转换
fun getStringLength12(obj: Any): Int? {
    if (obj !is String) return null
// `obj` 在这一分支自动转换为 `String`
    return obj.length
}

fun print12() {
    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength12(obj) ?: "... err, not a str ing"} ")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))
}

//13.使用类型检测及自动类型转换
fun getStringLength13(obj: Any): Int? {
// `obj` 在 `&&` 右边自动转换成 `String` 类型
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}

fun print13() {
    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength13(obj) ?: "... err, is empty or not a string at all"} ")
    }
    printLength("Incomprehensibilities")
    printLength("")
    printLength(1000)
}

//14.使用 for 循环
fun print14() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
}

//15.使用 for 循环
fun print15() {
    val items = listOf("apple", "banana", "kiwi")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

//16.使用 while 循环
fun print16() {
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

//17.使用 while 循环
fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

fun print17() {
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))
}

//18.使用 in 运算符来检测某个数字是否在指定区间内
fun print18() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }
}

//19.检测某个数字是否在指定区间外
fun print19() {
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }
}

//20.区间迭代
fun print20() {
    for (x in 1..5) {
        print(x)
    }
}

//21.数列迭代
fun print21() {
    for (x in 1..10 step 2) {
        print(x)
    }
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}

//22.对集合进行迭代
fun print22() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
}

//23.使用 in 运算符来判断集合内是否包含某实例
fun print23() {
    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}

//24.使用 lambda 表达式来过滤（filter） 和映射（map） 集合
fun print24() {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}
