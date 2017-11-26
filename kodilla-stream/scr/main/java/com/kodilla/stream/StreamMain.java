package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println(poemBeautifier.beautify("text", t -> t + "ABC"));
        System.out.println(poemBeautifier.beautify("text", t -> t.toUpperCase()));
        System.out.println(poemBeautifier.beautify("text", t -> t.replace("text", "newText")));
        System.out.println(poemBeautifier.beautify("text", t -> t.replaceFirst("t", "T")));
        System.out.println(poemBeautifier.beautify("text", String::toUpperCase));

        Forum theForum = new Forum();
        theForum.getUserList().stream()
                .filter(u -> u.getSex() == 'M')
                .forEach(u -> System.out.println(u.getSex()));

        theForum.getUserList().stream()
                .filter(f -> f.getBirthDate().getYear() > 1997)
                . forEach(f -> System.out.println(f.getBirthDate()));

        theForum.getUserList().stream()
                .filter(s -> s.getPostsNumber() > 1 )
                . forEach(s -> System.out.println(s.getPostsNumber()));

        Map<Integer, ForumUser> theResultMapOfUsers = theForum.getUserList().stream()
                .filter(user -> user.getID() == user.getID())
                .collect(Collectors.toMap(ForumUser::getID, user -> user));

        System.out.println("# elements: " + theResultMapOfUsers.size());
        theResultMapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}