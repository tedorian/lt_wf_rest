package api

import dao.ModulesDao

import scala.concurrent.ExecutionContext.Implicits.global
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import mappings.JsonMappings
import models.Module
import akka.http.scaladsl.server.Directives._
import spray.json._

trait ModulesApi extends JsonMappings{
  val modulesApi =
    (path("modules") & get ) {
      complete (ModulesDao.findAll.map(_.toJson))
    }~
    (path("modules"/IntNumber/"lentltypes") & get){ moduleId =>
        complete (ModulesDao.findLentilTypes(moduleId).map(_.toJson))
    }
}
