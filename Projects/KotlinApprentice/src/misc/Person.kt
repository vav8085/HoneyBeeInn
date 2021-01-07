package misc

class Person (val firstName: String, val lastName: String) {
    val fullName: String
    get() {
        return "$firstName $lastName"
    }
}