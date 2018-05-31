package ua.nure;

import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;

public class MyMongUserDAO implements UserInterface{

    private static MyMongUserDAO mdao = null;
    MongoClient m;
    DB db;
    DBCollection coll;

        public   MyMongUserDAO()
        {
            m = new MongoClient("127.0.0.1", 27017);
            db = m.getDB("MyMong2");
            coll = db.getCollection("User");
//в конструктор
        }



    @Override
    public void putToDB(List<User> list){
        for(int i = 0;i<list.size();i++){
            addUser(list.get(i));
        }}

    @Override
    public List<User> getAllUsers() {
        User temp2User = new User();
        List<User> list2 = new ArrayList<>();
       DBCursor cur =  coll.find();

        while(cur.hasNext()){
            DBObject o = cur.next();
            temp2User = new User.Builder(o.get("name").toString(),o.get("email").toString()).phone(o.get("phone").toString()).build();
            list2.add(temp2User);
        }

        return list2;

    }

    @Override
    public void addUser(User user) {

        BasicDBObject us = new BasicDBObject();

        us.put("name", user.getNicke());
        us.put("phone", user.getPhone());
        us.put("email", user.getEmail());

        coll.insert(us);

    }

    @Override
    public void updateUser(User userhave, User userwant) {

            BasicDBObject updhave = new BasicDBObject();
        updhave.put("name", userhave.getNicke());
        updhave.put("phone", userhave.getPhone());
        updhave.put("email", userhave.getEmail());

        BasicDBObject updwant = new BasicDBObject();
            updwant.put("name", userwant.getNicke());
            updwant.put("phone", userwant.getPhone());
            updwant.put("email", userwant.getEmail());


            coll.update(updhave,updwant);

    }

    @Override
    public void deleteUser(User userdel) {
        BasicDBObject usdel = new BasicDBObject();
        usdel.put("name", userdel.getNicke());
        usdel.put("phone", userdel.getPhone());
        usdel.put("email", userdel.getEmail());

        coll.remove(usdel);
    }
}
