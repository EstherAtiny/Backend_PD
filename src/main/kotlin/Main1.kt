import factorymethod.IDBAdapter
import factorymethod.PostgreSqlDBAdapter

fun main() {
    /*val property: Properties? = PropertiesUtil
        .loadProperty("properties/DBMySQL")
    println(property)
    val mySql:IDBAdapter=MySqlDBAdapter()
    println(mySql.getConnection().toString())
    val oracle: IDBAdapter=OracleDBAdapter()
    println(oracle.getConnection().toString())*/

    val postgresql: IDBAdapter=PostgreSqlDBAdapter()
    println(postgresql.getConnection().toString())

}