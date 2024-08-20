import java.util.Scanner

class ShowFun : CreateFun() {

    private val sc: Scanner = Scanner(System.`in`)

    fun showArchive(archive: Archive) {
        while (true) {
            println("Архив '${archive.nameArchive}':")
            println("0. Создать заметку")
            for (i in archive.noteList.indices) println("${i + 1}. ${archive.noteList[i].nameNote}")
            println("${archive.noteList.size + 1}. Назад")
            println("Введите номер команды:")

            val command = sc.nextLine().toIntOrNull()
            if (command == null) {
                println("Неверный ввод, нужно ввести число. Попробуйте ещё раз")
            }
            else {
                when (command) {
                    0 -> createNote(archive)
                    archive.noteList.size + 1 -> break
                    else -> {
                        if (command in 0..archive.noteList.size + 1) {
                            showNote(archive.noteList[command - 1])
                        } else println("Неверный ввод, такой цифры нет. Попробуйте ещё раз")
                    }
                }
            }
        }
    }

    private fun showNote(note: Note) {
        println("Заметка '${note.nameNote}':")
        println(note.textNote)

        while (true){
            println("\n1. Назад")
            println("Введите номер команды:\n")
            val command = sc.nextLine().toIntOrNull()
            when (command) {
                null -> println("Неверный ввод, нужно ввести число. Попробуйте ещё раз")
                1 -> break
                else -> println("Неверный ввод, такой цифры нет. Попробуйте ещё раз")
            }
        }
    }

}

