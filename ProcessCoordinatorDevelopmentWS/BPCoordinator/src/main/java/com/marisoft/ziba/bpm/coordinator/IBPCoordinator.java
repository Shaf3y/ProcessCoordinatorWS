package com.marisoft.ziba.bpm.coordinator;

import java.util.Map;

/** 
 * @author shaf3y
 *
 */
public interface IBPCoordinator {
	
	Map<String, Object> startProcess(String key, Map<String, Object> vars);
	
	void completeTask(String taskId, Map<String, Object> vars);
	void completeTask(Map<String,Object> taksMap, Map<String, Object> vars);
	void completeTask(String desc, String userId, Map<String, Object> vars) throws Exception;
	void completeTask(String desc, String userId) throws Exception;
	
	void delegateTaskWithReview(String taskId, String userId);
	void delegateTaskFullControl(String taskId, String userId);
	
	void resolveTask(String taskId);
	void assignTask(String taskId, String userId);
	
	void assertVariable();
	void signalProcess(String procInstId, String signalKey);
	boolean claimTask(String taskId, String userId);		
	
	void terminateProcessWith(String ProcessName, String varName, Object varValue, String reason);
	
}
