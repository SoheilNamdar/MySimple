package com.mkyong.Repository;

import com.mkyong.Entity.Credit;
import com.mkyong.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
