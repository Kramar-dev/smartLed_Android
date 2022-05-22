package com.smartled

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.settings, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("ShowToast")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item2 -> {
                Toast.makeText(this, "setting selected", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}





/*
* package com.smartled

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import io.ktor.client.*
import io.ktor.client.plugins.websocket.*
import io.ktor.http.*
import io.ktor.websocket.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val ipAddress = findViewById<EditText>(R.id.ipAddress)
        val port = findViewById<EditText>(R.id.port)
        val sendButton = findViewById<Button>(R.id.button)
        val message = findViewById<EditText>(R.id.message)


        val newThread = Thread {
            val client = HttpClient {
                install(WebSockets)
            }
            //TODO: add connect button
            runBlocking {
                client.webSocket(method = HttpMethod.Get,
                    host = ipAddress.text.toString(),
                    port = port.text.toString().toInt(),
                    path = "/") {

                    val message = findViewById<EditText>(R.id.message)

                    sendButton.setOnClickListener(){
                        launch {  outputMessages(message) }
                        //val text = "${ipAddress.text} ${port.text}"
                        //val duration = Toast.LENGTH_SHORT

                        //val toast = Toast.makeText(applicationContext, text, duration)
                        //toast.show()
                    }

                    val messageOutputRoutine = launch { outputMessages(message) }
                    val userInputRoutine = launch { inputMessages() }

                    userInputRoutine.join() // Wait for completion; either "exit" or error
                    messageOutputRoutine.cancelAndJoin()
                }
            }
            client.close()
            println("Connection closed. Goodbye!")
        }
        newThread.start()




    }
}


suspend fun DefaultClientWebSocketSession.inputMessages() {
    try {
        for (message in incoming) {
            message as? Frame.Text ?: continue
            println(message.readText())
        }
    } catch (e: Exception) {
        println("Error while receiving: " + e.localizedMessage)
    }
}


suspend fun DefaultClientWebSocketSession.outputMessages(message: EditText) {
    try {
        send(message.text.toString())
    } catch (e: Exception) {
        println("Error while sending: " + e.localizedMessage)
        return
    }
}*/