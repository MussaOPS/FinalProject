package com.example.demo.Service;

import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.Entity.Warehouse;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.WarehouseRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final WarehouseRepository warehouseRepository;

    public Service(UserRepository userRepository, ProductRepository productRepository, WarehouseRepository warehouseRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.warehouseRepository = warehouseRepository;
    }

    public List<User> showUsers() {
        return userRepository.findAll();
    }

    private boolean isUserExist(User user) {
        if (user == null) {
            System.out.println("User does not exist");
            return false;
        } else
            return true;
    }

    public void issueProduct(User user, Warehouse warehouse) {
        if (isUserExist(user)) {
            if (warehouse.isAvailable() == true) {
                BorrowBook issuedBooks = new BorrowBook(user, book);
                borrowBookRepository.save(issuedBooks);

                book.setAvailable(false);
                bookRepository.save(book);
            } else {
                System.out.println("Book is not available at the moment");
            }
        }
    }

    public void returnBook(User user, Book book) {
        if (isUserExist(user)) {
            if (book.isAvailable() == false) {
                BorrowBook rentBooks = borrowBookRepository.findByUserAndBook(user, book);
                if (rentBooks != null) {
                    book.setAvailable(true);
                    bookRepository.save(book);
                } else {
                    System.out.println("Error returning book.");
                }
            } else {
                System.out.println("Error returning book");
            }
        }
    }

}
