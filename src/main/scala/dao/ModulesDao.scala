package dao

import dao.ModulesDao._
import models._
import slick.dbio.Effect
import slick.driver.PostgresDriver.api._
import slick.profile.FixedSqlStreamingAction

import scala.concurrent.Future

object ModulesDao extends BaseDao{
  def findAll: Future[Seq[Module]] = modulesTable.result
  def findLentilTypes(moduleId: ModuleId): Future[Seq[Lentl_type]] = (for{
    submodule <- submodulesTable.filter(_.module_id === moduleId)
    lentltype <- lentil_typeTable.filter(_.submodule_id === submodule.id)
  } yield lentltype).result
}
