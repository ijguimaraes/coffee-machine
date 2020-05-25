package machine

import java.util.*

var waterStorage = 400
var milkStorage = 540
var beansStorage = 120
var cupsDisposableStorage = 9
var moneyStorage = 550

fun main() {
    val scanner = Scanner(System.`in`)
    val coffeeMachine = CoffeeMachine()
    do {
        val input = scanner.next()
        coffeeMachine.executeCommand(input)
    } while (!coffeeMachine.isExit())
}

enum class State {
    SHOW_ACTIONS,
    EXIT,
    WRITE_ACTION,
    CHOOSE_BUY,
    ADD_WATER,
    ADD_MILK,
    ADD_COFFEE_BEANS,
    ADD_CUPS
}

class CoffeeMachine {

    private var state = State.SHOW_ACTIONS

    init {
        showActions()
    }

    fun executeCommand(input: String) {
        when (state) {
            State.SHOW_ACTIONS -> {
                showActions()
            }
            State.WRITE_ACTION -> {
                writeAction(input)
            }
            State.CHOOSE_BUY -> {
                setChoose(input)
            }
            State.ADD_WATER -> {
                waterStorage += input.toInt()
                print("Write how many ml of milk do you want to add: >")
                state = State.ADD_MILK
            }
            State.ADD_MILK -> {
                milkStorage += input.toInt()
                print("Write how many grams of coffee beans do you want to add: >")
                state = State.ADD_COFFEE_BEANS
            }
            State.ADD_COFFEE_BEANS -> {
                beansStorage += input.toInt()
                print("Write how many disposable cups of coffee do you want to add: >")
                state = State.ADD_CUPS
            }
            State.ADD_CUPS -> {
                cupsDisposableStorage += input.toInt()
                showActions()
            }
            else -> showActions()
        }
    }

    fun isExit(): Boolean {
        return state == State.EXIT
    }

    private fun showActions() {
        print("Write action (buy, fill, take, remaining, exit): > ")
        state = State.WRITE_ACTION
    }

    private fun writeAction(input: String) {
        when (input) {
            "buy" -> buyCoffee()
            "fill" -> fillCoffeeMachine()
            "take" -> takeMoneyOfMachine()
            "remaining" -> printCoffeeMachineCapacity()
            "exit" -> doExit()
        }
    }

    private fun doExit() {
        state = State.EXIT
    }

    private fun takeMoneyOfMachine() {
        println("I gave you $$moneyStorage")
        moneyStorage = 0
    }

    private fun fillCoffeeMachine() {
        print("Write how many ml of water do you want to add: >")
        state = State.ADD_WATER
    }

    private fun buyCoffee() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: >")
        state = State.CHOOSE_BUY
    }

    private fun setChoose(choose: String) {
        if ("back" != choose) {
            when (choose) {
                "1" -> makeEspresso()
                "2" -> makeLatte()
                "3" -> makeCappuccino()
            }
        } else {
            showActions()
        }
    }

    private fun makeCappuccino() {
        val water = 200
        val milk = 100
        val beans = 12

        if (haveResource(water, milk, beans)) {
            waterStorage -= water
            milkStorage -= milk
            beansStorage -= beans
            moneyStorage += 6
            cupsDisposableStorage -= 1
        }

        showActions()
    }

    private fun makeLatte() {
        val water = 350
        val milk = 75
        val beans = 20

        if (haveResource(water, milk, beans)) {
            waterStorage -= water
            milkStorage -= milk
            beansStorage -= beans
            moneyStorage += 7
            cupsDisposableStorage -= 1
        }

        showActions()
    }

    private fun makeEspresso() {
        val water = 250
        val milk = 0
        val beans = 16

        if (haveResource(water, milk, beans)) {
            waterStorage -= water
            milkStorage -= milk
            beansStorage -= beans
            moneyStorage += 4
            cupsDisposableStorage -= 1
        }

        showActions()
    }

    private fun printCoffeeMachineCapacity() {
        println("The coffee machine has:")
        println("$waterStorage of water")
        println("$milkStorage of milk")
        println("$beansStorage of coffee beans")
        println("$cupsDisposableStorage of disposable cups")
        println("$moneyStorage of money")
        println()
        showActions()
    }

    private fun haveResource(water: Int, milk: Int, beans: Int): Boolean {
        return when {
            waterStorage < water -> {
                println("Sorry, not enough water!")
                false
            }
            milkStorage < milk -> {
                println("Sorry, not enough milk!")
                false
            }
            beansStorage < beans -> {
                println("Sorry, not enough coffee beans!")
                false
            }
            cupsDisposableStorage < 1 -> {
                println("Sorry, not enough disposable cups!")
                false
            }
            else -> {
                true
            }
        }
    }
}
