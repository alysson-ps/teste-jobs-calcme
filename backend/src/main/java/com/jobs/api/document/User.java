package com.jobs.api.document;

import org.springframework.data.annotation.Id;
import org.json.JSONObject;
import org.json.JSONException;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document
public class User {

  @Id
  public String id;
  public String name;

  public User(String name) {
    this.name = name;
  }

  public JSONObject response() throws JSONException{
    JSONObject data = new JSONObject();

    data.put("id",id);
    data.put("name",name);
    return data;
  }

}