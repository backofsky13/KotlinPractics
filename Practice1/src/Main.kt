import java.text.SimpleDateFormat
import java.util.*

data class Expense(val amount: Double, val category: String, val date: String) {
    fun printExpenseInfo() {
        println("Сумма: $amount, Категория: $category, Дата: $date")
    }
}

class ExpenseTracker {
    private val expenses = mutableListOf<Expense>()

    fun addExpense(amount: Double, category: String, date: String) {
        val expense = Expense(amount, category, date)
        expenses.add(expense)
        println("Добавлен новый расход: $amount, $category, $date")
    }

    fun printAllExpenses() {
        if (expenses.isEmpty()) {
            println("Нет добавленных расходов.")
        } else {
            println("Список всех расходов:")
            expenses.forEach { it.printExpenseInfo() }
        }
    }

    fun printExpensesByCategory() {
        if (expenses.isEmpty()) {
            println("Нет добавленных расходов.")
            return
        }

        val categoryTotals = mutableMapOf<String, Double>()
        for (expense in expenses) {
            categoryTotals[expense.category] = categoryTotals.getOrDefault(expense.category, 0.0) + expense.amount
        }

        println("Сумма расходов по категориям:")
        for ((category, total) in categoryTotals) {
            println("Категория: $category, Общая сумма: $total")
        }
    }
}

fun main() {


    val x : () -> Unit = {

    }

    val expenseTracker = ExpenseTracker()
    val dateFormatter = SimpleDateFormat("dd.MM.yyyy")
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\nВыберите действие:")
        println("1. Добавить новый расход")
        println("2. Показать все расходы")
        println("3. Показать сумму расходов по категориям")
        println("4. Выйти")

        when (scanner.nextLine()) {
            "1" -> {
                println("Введите сумму расхода:")
                val amount = scanner.nextDouble()

                println("Введите категорию расхода:")
                scanner.nextLine() // очищаем буфер после nextDouble
                val category = scanner.nextLine()

                val currentDate = dateFormatter.format(Date())
                expenseTracker.addExpense(amount, category, currentDate)
            }

            "2" -> expenseTracker.printAllExpenses()

            "3" -> expenseTracker.printExpensesByCategory()

            "4" -> {
                println("Выход из программы.")
                return
            }

            else -> println("Неверный выбор, попробуйте снова.")
        }
    }
}
