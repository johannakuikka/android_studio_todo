package com.example.todoappwithviewmodel.viewmodel;

import android.util.Log
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateListOf
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    var todos = mutableStateListOf<Todo>()
        private set

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi.getInstance()
                todos.clear()
                val fetchedTodos = todosApi.getTodos() // Tallenna tulos muuttujaan
                todos.addAll(fetchedTodos) // Lisää ne todo-listaan
                Log.d("TODOVIEWMODEL", "Fetched todos: $fetchedTodos")
            } catch (e: Exception) {
                Log.d("TODOVIEWMODEL", e.message.toString())
            }
        }
    }
}
