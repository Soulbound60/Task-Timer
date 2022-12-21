package com.example.tasktimer.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TaskTable::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        var instance: TaskDatabase? = null

        fun getInstance(context: Context): TaskDatabase {
            if (instance != null)
                return instance!!
            synchronized(this) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "MyDataBase"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        } //end get instance

    }// end obj

}// DB