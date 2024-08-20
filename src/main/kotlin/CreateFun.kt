import java.util.Scanner

open class CreateFun {
    private val sc: Scanner = Scanner(System.`in`)
    private val archiveList = mutableListOf<Archive>()

    fun createStartMenu() {
        while (true) {
            println("Список архивов:")
            println("0. Создать архив")
            for (i in archiveList.indices) println("${i + 1}. ${archiveList[i].nameArchive}")
            println("${archiveList.size + 1}. Выход")
            println("Введите номер команды:")

            val command = sc.nextLine().toIntOrNull()
            if (command == null){
                println("Неверный ввод, нужно ввести число. Попробуйте ещё раз")
            }
            else{
                when (command) {
                    0 -> createArchive()
                    archiveList.size + 1 -> break
                    else -> {
                        if (command in 0..archiveList.size + 1) {
                            val showArchive = ShowFun()
                            showArchive.showArchive(archiveList[command - 1])
                        }
                        else println("Неверный ввод, такой цифры нет. Попробуйте ещё раз")
                    }
                }
            }
        }
    }

    private fun createArchive() {
        println("Введите название архива:")
        var nameArchive = sc.nextLine()
        while (nameArchive.isBlank()) {
            println("Поле пустое, попробуйте еще раз.")
            println("Введите название архива:")
            nameArchive = sc.nextLine()
        }
        val newArchive = Archive(nameArchive)
        archiveList.add(newArchive)
        println("Создан архив '${newArchive.nameArchive}'.")
    }

    protected fun createNote(archive: Archive) {
        println("Введите название заметки:")
        var nameNote = sc.nextLine()
        while (nameNote.isBlank()) {
            println("Поле пустое, попробуйте еще раз.")
            println("Введите название заметки:")
            nameNote = sc.nextLine()
        }

        println("Введите текст заметки:")
        var textNote = sc.nextLine()
        while (textNote.isBlank()) {
            println("Поле пустое, попробуйте еще раз.")
            println("Введите текст заметки:")
            textNote = sc.nextLine()
        }

        val newNote = Note(nameNote, textNote)
        archive.noteList.add(newNote)
        println("Создана заметка '${newNote.nameNote}'.")
    }

}