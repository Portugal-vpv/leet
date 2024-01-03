package org.leetcode.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class Study {

  public record UserDto(String name, String lastName, String email, Long id) {}

  public record CompanyDto(String name, String license, Long id) {}

  public void test1() {
    Collection<String> collection = Arrays.asList("a", "b");
    Stream<String> streamOfCollection = collection.stream();
    streamOfCollection.map(String::toUpperCase).forEach(System.out::println);
  }

  public Optional<UserDto> findUserById(Long id) {
    UserDto user = new UserDto("John", "Smith", "john@email.com", id);
    return Optional.of(user);
  }

  public Optional<CompanyDto> findCompanyById(Long id) {
    CompanyDto company = new CompanyDto("Company", "fjkdfjaçsldkfjwoeif", id);
    return Optional.of(company);
  }

  public Future<Optional<UserDto>> getUserFuture() {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CompletableFuture<Optional<UserDto>> completableFuture = new CompletableFuture<>();
    executorService.submit(
        () -> {
          try {
            sleep(5000L);
            Study s = new Study();
            completableFuture.complete(s.findUserById(1L));
            System.out.println(Thread.currentThread().getName());

          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        });

    return completableFuture;
  }

  public Future<Optional<CompanyDto>> getCompanyFuture() {
    CompletableFuture<Optional<CompanyDto>> completableFuture = new CompletableFuture<>();
    Executors.newCachedThreadPool()
        .submit(
            () -> {
              try {
                sleep(10000L);
                Study s = new Study();
                completableFuture.complete(s.findCompanyById(1L));
                System.out.println(Thread.currentThread().getName());
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            });

    return completableFuture;
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Study s = new Study();
    Optional<UserDto> userDto = s.findUserById(1L);
    userDto.ifPresent(System.out::println);

    Optional<CompanyDto> companyDto = s.findCompanyById(1L);
    companyDto.ifPresent(System.out::println);

    Future<Optional<UserDto>> userFuture = s.getUserFuture();
    Future<Optional<CompanyDto>> companyFuture = s.getCompanyFuture();

    companyFuture.get().ifPresent(System.out::println);
    userFuture.get().ifPresent(System.out::println);
    System.out.println(Thread.currentThread().getName());
  }
}
