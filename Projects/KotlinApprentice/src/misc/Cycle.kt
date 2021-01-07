package misc

class Cycle(val handle: Int, val wheels: Int, val frame: Int, val seat: Int) {
    fun pedal(){
        print("moving!")
    }
    fun breaks(){
        print("stop!")
    }
}