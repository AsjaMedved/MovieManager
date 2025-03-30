package ru.netology.servise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    @Test
    public void ReturnEmptyArrayWhenNoMoviesAdded() {
        MovieManager maneger = new MovieManager();
        String[] expected = {};
        Assertions.assertArrayEquals(expected, maneger.findAll());
    }

    @Test
    public void addMovies() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        String[] expeted = {"Бладшот", "Вперед"};
        Assertions.assertArrayEquals(expeted, manager.findAll());
    }

    @Test
    public void ReturnLastMoviesWithDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек-невидимка", "Джентльмены", "Отель Белград", "Вперёд"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void ReturnLastMoviesWithCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентльмены");
        String[] expected = {"Джентльмены", "Отель Белград", "Вперёд"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }
}
