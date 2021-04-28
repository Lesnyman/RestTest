package api.petStore.pet;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class PetBody {
    long id;
    Category category;
    String name;
    List<String> photoUrls;
    List<Tags> tags;
    String status;

    public PetBody(long id, Category category, String name, List<String> photoUrls, List<Tags> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public JSONObject createBody() {
        JSONObject categoryBody = new JSONObject();
        categoryBody.put("id", category.id);
        categoryBody.put("name", category.name);
        JSONArray urlBody = new JSONArray();
        tags.forEach(tag -> {
            JSONObject urlObject = new JSONObject();
            urlObject.put("id", tag.id)
                    .put("name", tag.name);
            urlBody.put(urlObject);
        });

        JSONObject body = new JSONObject();
        body.put("id", id)
                .put("category", categoryBody)
                .put("name", name)
                .put("photoUrls", photoUrls)
                .put("tags", urlBody)
                .put("status", status);
        return body;
    }

    public static class Category{
        public final String name;
        public final Long id;

        public Category(Long id, String name){
            this.id = id;
            this.name = name;
        }
    }

    public static class Tags{
        public final long id;
        public final String name;

        public Tags(long id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
