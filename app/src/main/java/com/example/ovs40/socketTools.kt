package com.example.ovs

import java.io.OutputStream
import java.net.Socket

val client = Socket("192.168.43.63", 3302)
val input = client.getInputStream()
val output = client.getOutputStream()

fun send(output: OutputStream, message: String): String {

    output.write(message.toByteArray())
    return reciever()

}

fun send2(output: OutputStream, message: String): ArrayList<List<String>> {

    output.write(message.toByteArray())
    var list = arrayListOf<List<String>>()
    var status = ""
    while (true) {
        var tempMsg = reciever()
        if (tempMsg != "stop") {
            var temp = tempMsg.split(",").toList()
            list.add(temp)
        } else {
            break
        }

    }
    return list


}

fun reciever(): String {
    val recv = mutableListOf<Char>()
    var mesg = ""
    var conn = true
    while (conn) {

        val nextbyte = input.read()
        if (nextbyte.toChar() != '.')
            recv.add(nextbyte.toChar())
        else {
            val msg = recv.joinToString("")
            mesg = msg
            recv.clear()
            conn = false


        }

    }
    return mesg
}

fun login(output: OutputStream, data: String): String {
    return when (send(output, "login,$data")) {
        "success" -> "logged in"
        "login error" -> "login error"
        else -> "error"
    }


}

fun logout(output: OutputStream): String {
    //send("logout")
    return when (send(output, "logout")) {
        "logged out" -> "logged out"
        else -> "error"
    }
}

fun signup(output: OutputStream, data: String): String {
    return when (send(output, "signup,$data")) {
        "account created" -> "done"
        "username already exists" -> "account exists"
        else -> "error"
    }
}

fun createElection(output: OutputStream, data: String): String {
    return when (send(output, "create election,$data")) {
        "election created" -> "election has been created"
        "election already exists" -> "sorry the election already exists"
        else -> "error"

    }
}

fun addPositions(output: OutputStream, data: String): String {
    return send(output, "add positions,$data")
}

fun getElections(output: OutputStream): ArrayList<List<String>> {
    val list = send2(output, "view election")
    return list
}

fun selectElection(output: OutputStream, data: String): ArrayList<List<String>> {
    val election = send2(output, "select election,$data")
    return election
}

fun joinElection(output: OutputStream, data: String) {
    send(output, "join election,voter")

}

/*fun main() {

    println(login("18/1765,THimberland9"))
    //println(logout())
    //create election
    //println(send("signup,18/1765,olatunjivictor1819@gmail.com,THimberland9"))
    //print(signup("18/1771,olatunjivictor1819@gmail.com,THimberland011"))
    //println(send("login,18/1765,THimberland9"))
    //name, category, sch_dept, startingDate, startingtime, duration
    println(createElection("vas election,varonica adeleke school,16/06/2022,04:20PM,2"))
    println(getElections())
    println(selectElection("CES0217220"))


    //print(send("join election voter"))
    //candidate position,manefesto,bio,vision/mission
    //print(send("join election candidate,president,djjfnebejkbejkbwejbwejh,dcjbdjvbd,jnfnwfnwk"))

    //print(send("join election voter"))

    client.close()

}*/