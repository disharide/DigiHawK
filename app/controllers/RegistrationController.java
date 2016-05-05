package controllers;

import models.Service;
import play.Logger;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import com.fasterxml.jackson.databind.JsonNode;

import entity.ParentUser;

public class RegistrationController extends Controller {

	public Result get() {
		return ok(views.html.registration.form.render());
	}

	public Result success() {
		return ok(views.html.registration.thankyou.render());
	}

	@BodyParser.Of(value = BodyParser.Json.class)
	public Result saveUser() {

		JsonNode regJson = request().body().asJson();
		Logger.info("hello there " + regJson.asText());

		ParentUser user = Json.fromJson(regJson, ParentUser.class);

		Logger.info("all data " + user.toString());

		user.save();

		return ok(Json.toJson(new Service()));

	}

	public Result checkMail() {
		String mailId = request().getQueryString("mailId");

		Logger.info("searching user with email id=" + mailId);

		Service service = new Service();

		Integer totalCount = ParentUser.find.where().eq("email_id", mailId)
				.findRowCount();

		Logger.info("total number of users found :" + totalCount);

		if (totalCount > 0) {
			service.status = "FAILURE";
		}

		return ok(Json.toJson(service));
	}
}
