package factorymethod

import properties.PropertiesUtil
import properties.PropertiesUtil.loadProperty
import kotlin.reflect.full.createInstance

class DBFactory {
    private  val _DB_FACTORY_PROPERTY_URL = "properties/DBFactory"
    private  val _DEFAULT_DB_CLASS_PROP = "defaultDBClass"
    fun getDBadapter(dbType:DBYType?): IDBAdapter {
        return when (dbType) {
            DBYType.MYSQL -> MySqlDBAdapter()
            DBYType.ORACLE -> OracleDBAdapter()
            DBYType.POSTGRESQL -> PostgreSqlDBAdapter()
            else -> throw IllegalArgumentException("No soportado")
        }
    }

    val defaultDBAdapter: IDBAdapter?
        get() = try {

            val property = PropertiesUtil.loadProperty(_DB_FACTORY_PROPERTY_URL)
            val defaultDBClass = property!!.getProperty(_DEFAULT_DB_CLASS_PROP)
            Class.forName(defaultDBClass).kotlin.createInstance() as IDBAdapter
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
}