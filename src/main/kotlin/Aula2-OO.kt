package br.ifpb.pdm

import org.jetbrains.annotations.Nullable
import kotlin.time.times

fun main() {
    val repositorioAnimal = RepositorioAnimal()
    var opcao = 0
    while (opcao != 6) {
        menu()
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?: 0
        when (opcao) {
            0->{
                var nome:String;
                print("Digite o Nome a ser removido: ");
                nome = readlnOrNull() ?: "";
                if(!nome.isNullOrEmpty()){
                    repositorioAnimal.remover(nome);
                }
            }
            1 -> {
                var idade:Int=0;
                var color:String;
                print("Digite a idade: ");
                idade= readlnOrNull()?.toInt() ?: 0;
                print("Digite a cor:")
                color= readlnOrNull() ?: "";
                var cor:Color = Color.valueOf(color);
                val cachorro = Cachorro(idade,cor)
                cachorro.nome = "Rex"
                repositorioAnimal.adicionar(cachorro)
            }
            2 -> {
                var idade:Int=0;
                var color:String;
                print("Digite a idade: ");
                idade= readlnOrNull()?.toInt() ?: 0;
                print("Digite a cor:")
                color= readlnOrNull() ?: "";
                var cor:Color = Color.valueOf(color);
                val gato = Gato(idade,cor)
                gato.nome = "Felix"
                repositorioAnimal.adicionar(gato)
            }
            3 -> {
                var idade:Int=0;
                var color:String;
                print("Digite a idade: ");
                idade= readlnOrNull()?.toInt() ?: 0;
                print("Digite a cor:")
                color= readlnOrNull() ?: "";
                var cor:Color = Color;
                val passaro = Passaro(idade,cor)
                passaro.nome = "Piu"
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
                print("Digite a idade: ");
                idade= readlnOrNull()?.toInt() ?: 0;
                print("Digite a cor:")
                color= readlnOrNull() ?: "";
                var cor:Color = Color.valueOf(color);
                val homem =Homem(idade,cor);
                homem.nome="João";
                repositorioAnimal.adicionar(homem)
            }
        }

    }
}

enum class Color(val rgb:Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

open abstract class Animal(var idade: Int,var cor:Color) {
    open var nome: String = ""
        get() = "Animal: $field"
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
    override fun emitirSom() {
        println("Miau")
    }
}

class Passaro(idade: Int,cor: Color) : Animal(idade,cor) {
    override fun emitirSom() {
        println("Piu piu")
    }
}


class Homem(idade: Int,cor:Color) : Animal(idade,cor){
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
    println("6 - Sair")
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
        animais.removeIf{it.nome.equals(nome)};
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

