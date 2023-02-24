package abstractfactory

class EmployeeServiceWSImpl:IEmployeeService {
    //comentario 23/02/2013
    private val employees = listOf("SOA-Maria", "SOA-Rosalia", "SOA-Liliana")
    override fun getEmployee(): List<String> {
        return this.employees
    }
}