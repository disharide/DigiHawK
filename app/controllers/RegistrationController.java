package controllers;

import models.Service;

import com.fasterxml.jackson.databind.JsonNode;

import entity.User;
import play.Logger;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

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

		User user = Json.fromJson(regJson, User.class);

		Logger.info("all data " + user.toString());

		user.save();

		return ok(Json.toJson(new Service()));

	}

	public Result checkMail() {
		String mailId = request().getQueryString("mailId");

		Logger.info("searching user with email id=" + mailId);

		Service service = new Service();

		Integer totalCount = User.find.where().eq("email_id", mailId)
				.findRowCount();

		Logger.info("total number of users found :" + totalCount);

		if (totalCount > 0) {
			service.status = "FAILURE";
		}

		return ok(Json.toJson(service));
	}
}
