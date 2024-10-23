package com.example.todoappwithviewmodel.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.todoappwithviewmodel.ui.theme.TodoAppWithViewmodelTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoappwithviewmodel.viewmodel.Todo
import com.example.todoappwithviewmodel.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppWithViewmodelTheme {
                    TodoScreen()
                }
            }
        }
    }

@Composable
fun TodoScreen(todoViewModel: TodoViewModel = viewModel()) {
    Log.d("TODOVIEWMODEL", "Todos list size: ${todoViewModel.todos.size}")
    TodoList(todoViewModel.todos)
}

@Composable
fun TodoList(todos: List<Todo>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(todos) { todo ->
            Text(
                text = todo.title,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
            )
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}