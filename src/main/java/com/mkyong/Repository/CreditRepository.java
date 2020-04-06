package com.mkyong.Repository;

import com.mkyong.Entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {

}
