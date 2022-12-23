package com.example.tasktimer.View

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tasktimer.Model.Timer
import com.example.tasktimer.ViewModel.MainViewModel
import com.example.tasktimer.ViewModel.TasksRV
import com.example.tasktimer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), TasksRV.ClickListner {
    private lateinit var binding: ActivityMainBinding

    private lateinit var rvAdapter: TasksRV
    var totalTime = ""

    lateinit var taskT: Chronometer


     val viewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        taskT=binding.timer
        val timer = Timer(this)


        rvAdapter = TasksRV(this)
        binding.rvItems.adapter = rvAdapter


        viewModel.getTasks().observe(this, { taskslist ->
            rvAdapter.update(taskslist)
        }) //view model


        binding.apply {
            bAdd.setOnClickListener {
                timer.startTimer()
            }// add btn

            showAll.setOnClickListener {
                totalTime = taskT.text.toString()
                timer.pauseTimer()

                Log.d("checkthis","$totalTime")
            } //show all btn
        }// apply



    }//end create

    fun intentToAddTask() {
        var intent = Intent(this, AddTaskActivity::class.java)
        startActivity(intent)

    }

//    fun TimerFun(){
//        object : CountDownTimer(100000, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                var time=millisUntilFinished / 1000
//                time = time * -1 + 100
//                taskTimer = time
//                binding.timer.text  = time.toString()
//                binding.timer.timer
//                //binding.counter.text = "Time: $time"
//                Log.d("timer", "$time ")
//                Log.d("timertask", "$taskTimer ")
//            }
//
//            override fun onFinish() {
//                //binding.counter.text = "Time: --"
//
//            }
//        }.start()
//    }

    //________________________________________________________/
    fun splitTime(num:Long):String{
        var hours:Int = (num /60).toInt()
        var minute = num /60
        var sec = num

        if (sec.toInt() == 60){
        }
        return " "
    }





}