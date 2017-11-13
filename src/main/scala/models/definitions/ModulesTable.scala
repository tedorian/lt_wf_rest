package models.definitions

/**
  * Created by trevorchristie-taylor on 14/9/17.
  */


import models.{Module, ModuleId}
import slick.driver.PostgresDriver.api._

class ModulesTable(tag: Tag) extends Table[Module](tag, "module"){
  def id = column[ModuleId]("id", O.PrimaryKey, O.AutoInc)
  def uri = column[String]("uri")
  def name = column[String]("name")
  def * = (id.?, uri, name) <> ((Module.apply _).tupled, Module.unapply)
}
