package castisvn.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import castisvn.entities.Report;

@Repository
@Transactional
public interface ReportRepository extends JpaRepository<Report, Integer>, JpaSpecificationExecutor<Report>{
	@Query("SELECT r FROM Report r WHERE r.userId = :userId ORDER BY r.issuedDate DESC")
	public Page<Report> getReportByUserId(@Param("userId") Integer userId, Pageable page);
	
	@Query(value = "select * from daily_report order by issued_date desc", nativeQuery = true)
	public List<Report> findAllDescIssuedDate();
		
	@Query("SELECT r FROM Report r WHERE r.reporter = :reporter ORDER BY r.issuedDate DESC")
	public List<Report> findAllByReporter(@Param(value = "reporter") String reporter);
	
	@Query("SELECT r FROM Report r WHERE r.userId = :userId ORDER BY r.issuedDate DESC")
	public List<Report> findAllByUserId(@Param(value = "userId") String reporterId);
	
	@Query(value = "SELECT * FROM daily_report  WHERE project in (:project) ORDER BY issued_date DESC", nativeQuery = true)
	public List<Report> findAllByProjectInList(@Param(value = "project") ArrayList<String> project);
	
	@Query("SELECT r FROM Report r WHERE r.position = :position ORDER BY r.issuedDate DESC")
	public List<Report> findAllByPosition(@Param(value = "position") String position);
	
	@Query("SELECT r FROM Report r WHERE (:reporter = '' or :reporter is null or r.reporter = :reporter) and (coalesce(:project) is null or r.project in (:project) ) and (:position = '' or :position is null or r.position = :position) ORDER BY r.issuedDate DESC")
	public Page<Report> findAllByCondition(@Param(value = "reporter") String reporter, @Param(value = "project") ArrayList<String> project, @Param(value = "position") String postion, Pageable pageable);
	
	public default Page<Report> findByCriteria(String reporter, ArrayList<String> project, String position, Pageable pageable){
		return findAll(new Specification<Report>() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Report> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				List<Predicate> predicates = new ArrayList<>();
				if(reporter != "" && reporter != null) {
					predicates.add(criteriaBuilder.equal(root.get("reporter"), reporter));
				}
				if(project != null) {
					predicates.add(root.get("project").in(project));
				}
				if(position != "" && position != null) {
					predicates.add(criteriaBuilder.equal(root.get("position"), position));
				}				
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageable);
	}
	public default Page<Report> findBySpecs(String reporter, ArrayList<String> project, String position, Pageable pageable){
		return findAll(ReportSpecs.filterByReporterProjectPosition(reporter, project, position),pageable);
	}
	
	public default Page<Report> findBySpecsAndLevel(String reporter, ArrayList<String> project, String position, String level, String sort,Pageable pageable){
		return findAll(Specification.where(ReportSpecs.filterByReporterProjectPosition(reporter, project, position)).and(ReportSpecs.hasLevelOfWork(level, sort)) ,pageable);
	}
}
