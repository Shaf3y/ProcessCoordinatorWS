package com.marisoft.ziba.bpe.api;

import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;

/**
 * An example service interface that may be exported to other bundles for use.
 */
public interface BusinessProcessEngineDelegate {

	/**
	 * An example service operation that processes an input and returns an
	 * output.
	 * 
	 * @param input
	 *            the service input
	 * @return the output
	 */
	

	public static String DIAGRAM_IMAGE_TYPE_PNG = "png";
	public static String DIAGRAM_IMAGE_TYPE_JPG = "jpg";
	
	
	///Util APIs
	public void storeVar(String varName, Object VarVal);
	public Object retrieveVar(String varName);
	
	//////  Process Instance APIs
	public void terminateProcessWith(String ProcessName, String varName, Object varValue, String reason);
	
	//////	Runtime Services APIs
	public Map<String, Object> startProcess(String key, Map<String,Object> vars);
	public void signalProcess(String procInstId, String signalKey);
	public void setVariables(String execId,Map<String,Object> vars);
	public Map<String,Object> getVariables(String execId);
	public void setVariable(String execId,String var,Object val);
	public Object getVariable(String execId,String var);
	public void setLocalVariables(String execId,Map<String,Object> vars);
	public Map<String,Object> getLocalVariables(String execId);
	public void setLocalVariable(String execId,String var,Object val);
	public Object getLocalVariable(String execId,String var);
	
	/////    Task Service APIs 
	public void setTaskVariables(String taskId,Map<String,Object> vars);
	public Map<String,Object> getTaskVariables(String taskId);
	public void setTaskVariable(String taskId,String var,Object val);
	public Object getTaskVariable(String taskId,String var);
	
	public void setTaskLocalVariables(String taskId,Map<String,Object> vars);
	public Map<String,Object> getTaskLocalVariables(String taskId);
	public void setTaskLocalVariable(String taskId,String var,Object val);
	public Object getTaskLocalVariable(String taskId,String var);
	
	public boolean claimTask(String taskId,String userId);
	public void completeTask(String taskId, Map<String,Object> vars);
	public void completeTask(Map<String, Object> taskModel, Map<String,Object> vars);
	public void completeTask(String desc,String userId,Map<String, Object> vars) throws Exception;
	public void completeTask(String desc,String userId) throws Exception;
	public void delegateTaskWithReview(String taskId, String userId);
	public void delegateTaskFullControl(String taskId, String userId);
	public void resolveTask(String taskId);
	public void assinTask(String taskId,String userId);
	public void addTaskComment(String taskId, String processInstanceId, String comment);
	public List<String> getTaskComments(String taskId);
	public void setTaskPriority(String taskId,int priority);
	public List<Map<String,String>> listActiveTasks(String userId);
	public Map<String,String> getActiveUserTask(String processInstanceId,String taskKey);
	
	public List<String> getUnfinishedProcessIdsInitiatedByUser(String userId);
	public List<String> getFinishedProcessIdsInitiatedByUser(String userId);
	public List<String> getAllProcessIdsInitiatedByUser(String userId);
	public List<Map<String, String>> listPendingTasksOfProcess(String procId);
	public List<Map<String, String>> listClaimedTasksForUser(String userId);
	public List<Map<String, String>> listAvailableTasksForCandidate(String userId);
	public List<Map<String, String>> listAvailableTasksForGroup(String groupId);
	public List<String> listUserGroupIDs(String userId);
	
	
	//public void attachTaskObject(String taskId);//to do
	//public void getTaskAttachments(String taskId);//to do
	//public void getAttachmentContent(String attId);//to do
	
	///////	Identity APIs
	public boolean checkPassword(String userId, String password);
	public void setAuthenticatedUserId(String userId);
	
	// Graphs APIs
	public byte[] getProcessInstanceGraph(String processInstanceId, String diagramImageType) throws Exception;
	public byte[] getProcessDefinitionGraph(String processDefinitionId) throws Exception;
	public void executeJob();
	//////	History APIs
	
	
	
	public void deleteProcessInstance(String processInstanceId, String deleteReason);
	public void deleteAllProcessInstances();
	
	ProcessEngine getEngine();
	
	
}
