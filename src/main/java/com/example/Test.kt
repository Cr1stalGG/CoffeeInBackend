package com.example

import kotlinx.coroutines.*
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.random.Random

fun timer(time: Double) {
    GlobalScope.launch{
        var time_changeble = time

        while (time_changeble > 0) {
            println(String.format("%.1f", time_changeble))
            time_changeble -= 0.1
            delay(100)
        }

        println("=============================================")
        println("TIMER IS OVER!!!")
        println("=============================================")
    }

}

fun testC(){
    GlobalScope.launch {
        println("Courutine started")
    }
}

//fun main() {
//    val scanner: Scanner = Scanner(System.`in`)
//
//    while (true) {
//        print("Input time(seconds): ")
//        val time = scanner.nextDouble()
//
//        if(time <= 0){
//            println("Invalid time format!!!!")
//            continue
//        }
//        thread {
//            timer(time)
//            testC()
//            println(Thread.currentThread().toString() + "is closed()")
//        }
//    }
//
//}
val threadPool: MutableList<String> = CopyOnWriteArrayList()

fun coroutine(): Unit = runBlocking {

    repeat(1000) {
        launch(Dispatchers.IO) {
            Thread.sleep(200)

            val threadName = Thread.currentThread().name
            threadPool += threadName
        }
    }
}

fun main(){
    coroutine()
    Thread.yield()

    var maxThread: Int = 0
    for(i: Int in 1..88)
        if(threadPool.stream().anyMatch { it.contains(i.toString()) })
            maxThread = i

    println(maxThread)
}