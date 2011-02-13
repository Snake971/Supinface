package controllers;

import models.MyExclusionStrategy;
import models.User;
import play.mvc.Controller;

/**
 * Created by IntelliJ IDEA.
 * User: boris
 * Date: 12/02/11
 * Time: 22:15
 */
public class UserController extends Controller{

    public static void getUserById(Long id)
    {
        User user = User.findById(id);
        throw new RenderJson(user,new MyExclusionStrategy(String.class));
    }

    public static void getUserByIdBooster(Long idBooster)
    {
        User user = User.find("byIdBooster",idBooster.toString()).first();
        System.out.println(user);
        throw new RenderJson(user,new MyExclusionStrategy(String.class));
    }
}
