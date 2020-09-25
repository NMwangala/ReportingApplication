package io.mwangala.entity;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report,Integer>{
	
	@Query(value="SELECT ITEM_TYPE,SUM(TOTAL_PROFIT) AS totalItemProfit FROM REPORTS.TBREPORTS WHERE ORDER_DATE"
			+ " BETWEEN ?1 AND ?2 GROUP BY ITEM_TYPE ORDER BY totalItemProfit DESC LIMIT 5"
			, nativeQuery=true)
	List<Object[]> getProfitableItems(String start, String end);

	@Query(value="SELECT SUM(TOTAL_PROFIT) FROM REPORTS.TBREPORTS WHERE ORDER_DATE BETWEEN ?1 AND ?2"
			 , nativeQuery=true)
	Double getTotalProfit(String start, String end);
}
