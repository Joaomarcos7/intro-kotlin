package br.ifpb.pdm

import org.jetbrains.annotations.Nullable
import kotlin.time.times

fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 0
    while (opcao != 7) {
        menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?: 0
        when (opcao) {
            0->{
                var nome:String;
                print("Digite o Nome a ser removido:");
                nome = readlnOrNull() ?: "";
                repositorioAnimal.remover(nome);
                println("Nova lista:")
                repositorioAnimal.listar();1
            }
            1 -> {
                var idade:Int=0;
                var color:String;
                var nome:String;
                print("Digite a idade: ");
                idade= readlnOrNull()?.toInt() ?: 0;
                print("Digite a cor:")
                color= readlnOrNull() ?: "";
                var cor:Color = Color.valueOf(color);
                print("Digite o nome:")
                nome= readlnOrNull() ?: "";
                val cachorro = Cachorro(idade,cor)
                cachorro.nome = nome
                repositorioAnimal.adicionar(cachorro)
            }
            2 -> {
                var idade:Int=0;
                var color:String;
                var nome:String;
                print("Digite a idade: ");
                idade= readlnOrNull()?.toInt() ?: 0;
                print("Digite a cor:")
                color= readlnOrNull() ?: "";
                var cor:Color = Color.valueOf(color);
                print("Digite o nome:")
                nome= readlnOrNull() ?: "";
                val gato = Gato(idade,cor)
                gato.nome = nome;
                repositorioAnimal.adicionar(gato)
            }
            3 -> {
                var idade:Int=0;
                var color:String;
                var nome:String;
                print("Digite a idade: ");
                idade= readlnOrNull()?.toInt() ?: 0;
                print("Digite a cor:")
                color= readlnOrNull() ?: "";
                var cor:Color = Color.valueOf(color);
                print("Digite o nome:")
                nome= readlnOrNull() ?: "";
                val passaro = Passaro(idade,cor)
                passaro.nome = nome;
                repositorioAnimal.adicionar(passaro)
            }
            4 -> {
                repositorioAnimal.listar()
            }
            5 -> {
                repositorioAnimal.animais.forEach(Animal::emitirSom)
                repositorioAnimal.animais.forEach { it.emitirSom()}
            }
            6->{
                var idade:Int=0;
                var color:String;
                var nome:String;
                print("Digite a idade: ");
                idade= readlnOrNull()?.toInt() ?: 0;
                print("Digite a cor:")
                color= readlnOrNull() ?: "";
                var cor:Color = Color.valueOf(color);
                print("Digite o nome:")
                nome= readlnOrNull() ?: "";
                val homem =Homem(idade,cor);
                homem.nome=nome;
                repositorioAnimal.adicionar(homem)
            }
        }

    }
}

enum class Color(val rgb:String){
    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    WHITE("white")
}

open abstract class Animal(var idade: Int,var cor:Color) {
    open var nome: String = ""
        get() = field;
        set(valor) {
            field = valor
        }

    open abstract fun emitirSom();

    open fun idadeEmAnosHumanos(): Int {
        return this.idade * 7;
    }
}

class Cachorro(idade: Int,cor:Color) : Animal(idade,cor) {
    override var nome: String = ""
        get() = field
        set(valor) {
            field = valor
        }
    override fun emitirSom() {
        println("Au au")
    }
}
class Gato(idade: Int,cor: Color) : Animal(idade,cor) {

    override var nome: String = ""
        get() = field
        set(valor) {
            field = valor
        }
    override fun emitirSom() {
        println("Miau")
    }
}

class Passaro(idade: Int,cor: Color) : Animal(idade,cor) {

    override var nome: String = ""
        get() = field
        set(valor) {
            field = valor
        }
    override fun emitirSom() {
        println("Piu piu")
    }
}


class Homem(idade: Int,cor:Color) : Animal(idade,cor){

    override var nome: String = ""
        get() = field
        set(valor) {
            field = valor
        }
    override fun idadeEmAnosHumanos(): Int {
        return super.idadeEmAnosHumanos() / 7;
    }
    override fun emitirSom() {
        println("Olá Pessoal!");
    }

}

fun menu() {
    println("0 - Remover Animal")
    println("1 - Cachorro")
    println("2 - Gato")
    println("3 - Pássaro")
    println("4 - Listar Animais")
    println("5 - Emitir som")
    println("6 - Homem")
    println("7 - Sair")
}

class RepositorioAnimal {
    val animais: MutableList<Animal> = mutableListOf()

    fun adicionar(animal: Animal) {
        animais.add(animal)
    }

    fun listar() {
        animais.forEach { println(it.nome) }
    }

    fun remover(nome:String){
      animais.removeIf { it.nome.equals(nome) }
    }


    fun listarDeCorX(cor:Color):MutableList<Animal>{
        return animais.filter { it.cor.equals(cor); }.toMutableList();
    }

    fun listarDeIdadeX(idade: Int):MutableList<Animal>{
        return animais.filter { it.idade == idade; }.toMutableList();
    }

    fun findByNome(nome:String):Animal?{
        return animais.find { it.nome.equals(nome,ignoreCase = true) }
    }
}

