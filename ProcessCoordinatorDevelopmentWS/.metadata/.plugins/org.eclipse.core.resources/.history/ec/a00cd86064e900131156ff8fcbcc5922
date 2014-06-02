package com.marisoft.ziba.bpe.activiti;

import java.io.InputStream;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.bpmn.diagram.ProcessDiagramGenerator;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ExecutionQuery;
import org.activiti.engine.runtime.Job;
import org.activiti.engine.runtime.JobQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

import com.marisoft.ziba.bpe.api.BusinessProcessEngineDelegate;

public class BusinessProcessEngineActiviti implements BusinessProcessEngineDelegate {
    /*
	private static final Logger logger = LoggerFactory
			.getLogger(BusinessProcessEngineActiviti.class);
    /*
    private IZIBALoggerFactory ZIBALoggerFactory;
    private IZIBALogger logger;
    //*/
	private ProcessEngine processEngine;
	private RuntimeService runtimeService;
	private TaskService taskService;
	private IdentityService identityService;
	private HistoryService historyService;
	private ManagementService managementService;
	private RepositoryService repositoryService;
	private Map<String,Object> vars;
//	private ZIBAContextBeans zibaContextBeans;

	public BusinessProcessEngineActiviti() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
//        zibaContextBeans = new ZIBAContextBeans();
//        ZIBALoggerFactory = zibaContextBeans.getService(IZIBALoggerFactory.class);
//        logger = ZIBALoggerFactory.getLogger();

//		//		logger.info("BusinessProcessEngineActiviti.BusinessProcessEngineActiviti(): Creating the Process Engine Config from Resource...");
		ProcessEngineConfiguration engineConf = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		
		// Add External Configuration
		engineConf.setJdbcUrl("jdbc:postgresql://localhost:5432/activiti_event_based?autoReconnect=true");
		engineConf.setJdbcDriver("org.postgresql.Driver");
		engineConf.setJdbcUsername("postgres");
		engineConf.setJdbcPassword("postgres");
		engineConf.setJobExecutorActivate(true);
		engineConf.setDatabaseSchemaUpdate("true");
				
		//		logger.info("BusinessProcessEngineActivitiDriver: Jdbc Driver: " + engineConf.getJdbcDriver());
		
		//		logger.info("BusinessProcessEngineActiviti.BusinessProcessEngineActiviti(): Registering the JDBC driver if it is not already registered...");
		registerDatabaseDriver(engineConf.getJdbcDriver());

		//		logger.info("BusinessProcessEngineActiviti.BusinessProcessEngineActiviti(): Building the Process Engine...");
		processEngine = engineConf.buildProcessEngine();		
				
		//		logger.info("BusinessProcessEngineActiviti.BusinessProcessEngineActiviti(): Getting Run Time Service...");
		runtimeService = processEngine.getRuntimeService();
		runtimeService.addEventListener(new ActivitiEngineEventListener());
		
		//		logger.info("BusinessProcessEngineActiviti.BusinessProcessEngineActiviti(): Getting Task Service...");
		taskService = processEngine.getTaskService();
		
		identityService = processEngine.getIdentityService();
		historyService = processEngine.getHistoryService();
		vars = new HashMap<String, Object>();
		
		repositoryService = processEngine.getRepositoryService();
		managementService = processEngine.getManagementService();
		
		//		logger.info("BusinessProcessEngineActiviti.BusinessProcessEngineActiviti(): Finished Initilizing.");
	}
	
	/**
	 * Used for testing purposes only
	 */
	protected BusinessProcessEngineActiviti(String d) {
		ProcessEngineConfiguration engineConf = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		// Custom DB configuration
		engineConf.setJdbcUrl("jdbc:postgresql://192.168.137.50:5432/activiti511?autoReconnect=true");
		engineConf.setJdbcDriver("org.postgresql.Driver");
		engineConf.setJdbcUsername("ziba");
		engineConf.setJdbcPassword("ziba");
		
		processEngine = engineConf.buildProcessEngine();
		runtimeService = processEngine.getRuntimeService();
		taskService = processEngine.getTaskService();
		identityService = processEngine.getIdentityService();
		historyService = processEngine.getHistoryService();
		vars = new HashMap<String, Object>();
	}
	
	/**Fixing issue ZIBA-4
	 * @param JdbcDriverClassName Driver name, this should get retrieved from the configuration files and not hard-coded.
	 */
	private void registerDatabaseDriver(String JdbcDriverClassName) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		boolean isDriverRegistered = false;
		Class<Driver> dbDriverClass = (Class<Driver>) Class.forName(JdbcDriverClassName);
		
		Enumeration<Driver> enm = DriverManager.getDrivers();
		while (enm.hasMoreElements()){
			Driver driver = enm.nextElement();
			if (driver.getClass().isInstance(dbDriverClass))
				isDriverRegistered = true;
		}
		if (! isDriverRegistered)
			DriverManager.registerDriver(dbDriverClass.newInstance());
	}

	
	public synchronized Map<String, Object> startProcess(String key, Map<String, Object> vars) {
//        logger = ZIBALoggerFactory.getLogger();
		if(vars==null) vars=new HashMap<String, Object>();
		ProcessInstance pi= null;
		Map<String,Object> res=null;
		try{
			setAuthenticatedUserId((String)vars.get("UserID"));
			pi= runtimeService.startProcessInstanceByKey(key, vars);
			res = new HashMap<String, Object>();
			res.put( "ProcessInstanceID" , pi.getProcessInstanceId());
			res.put( "BusinessKey" , pi.getBusinessKey());
			
			System.out.println("Process Instance Id:" + pi.getProcessInstanceId());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return res;
	}

	
	public void signalProcess(String procInstId, String signalKey) {
		ExecutionQuery eq = runtimeService.createExecutionQuery().activityId(signalKey).processInstanceId(procInstId);
		Execution e = eq.singleResult();
		if(e!=null)
			runtimeService.signal(e.getId());
	}

	
	public void setVariables(String execId,Map<String, Object> vars) {
		
		runtimeService.setVariables(execId, vars);
	}

	
	public Map<String, Object> getVariables(String execId) {
		
		return runtimeService.getVariables(execId);
	}

	
	public void setVariable(String execId,String var, Object val) {
		
		runtimeService.setVariable(execId, var, val);
	}

	
	public Object getVariable(String execId,String var) {
		
		return runtimeService.getVariable(execId, var);
	}
	
	
	public void setLocalVariables(String execId,Map<String, Object> vars) {
		
		runtimeService.setVariablesLocal(execId, vars);
	}

	
	public Map<String, Object> getLocalVariables(String execId) {
		
		return runtimeService.getVariablesLocal(execId);
	}

	
	public void setLocalVariable(String execId,String var, Object val) {
		
		runtimeService.setVariableLocal(execId, var, val);
	}

	
	public Object getLocalVariable(String execId,String var) {
		
		return runtimeService.getVariableLocal(execId, var);
	}

	
	public void setTaskVariables(String execId,Map<String, Object> vars) {
		
		taskService.setVariables(execId, vars);
	}

	
	public Map<String, Object> getTaskVariables(String execId) {
		
		return taskService.getVariables(execId);
	}

	
	public void setTaskVariable(String execId,String var, Object val) {
		
		taskService.setVariable(execId, var, val);
	}

	
	public Object getTaskVariable(String execId,String var) {
		
		return taskService.getVariable(execId, var);
	}

	
	public void setTaskLocalVariables(String execId,Map<String, Object> vars) {
		
		taskService.setVariablesLocal(execId, vars);
	}

	
	public Map<String, Object> getTaskLocalVariables(String execId) {
		
		return taskService.getVariablesLocal(execId);
	}

	
	public void setTaskLocalVariable(String execId,String var, Object val) {
		
		taskService.setVariableLocal(execId, var, val);
	}

	
	public Object getTaskLocalVariable(String execId,String var) {
		
		return taskService.getVariableLocal(execId, var);
	}
	
	public boolean claimTask(String taskId, String userId) {
//        logger = ZIBALoggerFactory.getLogger();
		try{
		taskService.claim(taskId, userId);
			return true;
		}catch (ActivitiException e) {
//			logger.error("Internal Application Error", e);
			return false;
		}
	}

	public void completeTask(String taskId, Map<String, Object> vars) {
//        logger = ZIBALoggerFactory.getLogger();
		if(vars==null) vars = new HashMap<String, Object>();
//		String processInstId = taskService.createTaskQuery().taskId(taskId).singleResult().getProcessInstanceId();
//		String userId = getAuthenticatedUserId(procesInstId);
//		vars.put("ZIBAFromUser", userId);
		vars.put("ZIBAFromUser", vars.get("RECEIVED_BY_USER"));
		//		logger.info("BusinessProcessEngineActiviti.completeTask(): vars: " + vars );
		taskService.complete(taskId, vars);
	}
	

	public void completeTask(Map<String, Object> taskMap, Map<String, Object> vars) {
		if(vars==null) vars = new HashMap<String, Object>();

		// Find all vars which start with BP_VAR_
		for (String key: taskMap.keySet())
		{
			if (key.startsWith("BP_VAR_")){
				String tempKey = key.replace("BP_VAR_", "");
				vars.put(tempKey, taskMap.get(key));
			}
		}
		vars.put("ZIBAFromUser", (String) taskMap.get("RECEIVED_BY_USER")); // VERY Temporarilly, this should be converted to match the above "BP_VAR_" prefix.
//		vars.put("ZIBAFromUser", taskMap.get("RECEIVED_BY_USER"));
		String taskId = (String) taskMap.get("TaskId");
		taskService.complete(taskId, vars);
	}
	
	
	public void completeTask(String desc, String userId, Map<String, Object> vars) throws Exception {
		TaskQuery tq = taskService.createTaskQuery();
		Task task = tq.taskAssignee(userId).taskDescription(desc).singleResult();
		if(vars == null) vars = new HashMap<String, Object>();
		if(task!=null) {
			taskService.complete(task.getId(),vars);
//			logger.info("Task is completed  >>>>>>>>>> [ "+desc+" ]      [ "+userId+" ]  >>>>>>>>>>>>>>>>>>   "+task);
		}
		else {
            tq = taskService.createTaskQuery();
            task = tq.taskCandidateUser(userId).taskDescription(desc).singleResult();
            if(task!=null) {
                taskService.claim(task.getId(),userId);
                taskService.complete(task.getId(),vars);
//                logger.info("Task is completed  >>>>>>>>>> [ "+desc+" ]      [ "+userId+" ]  >>>>>>>>>>>>>>>>>>   "+task);
            }
            else throw new Exception("Unknown task, you as ["+userId +"] are not assigned to task with description: "+desc);
        }
	}
	
	
	public void completeTask(String desc, String userId) throws Exception{
		completeTask(desc, userId, null);
	}

	
	public void delegateTaskWithReview(String taskId, String userId) {
		
		taskService.delegateTask(taskId, userId);
	}

	
	public void delegateTaskFullControl(String taskId, String userId) {
		
		taskService.setOwner(taskId, userId);
		taskService.setAssignee(taskId, userId);
	}
	
	
	public void resolveTask(String taskId){
		taskService.resolveTask(taskId);
	}

	
	public void assinTask(String taskId, String userId) {
		
		taskService.setAssignee(taskId, userId);
	}

	
	public void addTaskComment(String taskId, String processInstanceId,
			String comment) {
		
		taskService.addComment(taskId, processInstanceId, comment);
	}

	
	public List<String> getTaskComments(String taskId) {
		
		List<Comment> comments = taskService.getTaskComments(taskId);
		List<String> strComments = new ArrayList<String>();
		for(Comment comment: comments) strComments.add(comment.getFullMessage());
		return strComments;
	}

	
	public void setTaskPriority(String taskId, int priority) {
		
		taskService.setPriority(taskId, priority);
	}
	
	private Map<String,String> createTaskMap(Task t){
//        logger = ZIBALoggerFactory.getLogger();
		Map<String,String> taskMap = new HashMap<String, String>();
		taskMap.put("TaskId",t.getId());
		//taskMap.put("TaskExecId",t.getExecutionId());
		taskMap.put("TaskName", t.getName());
		taskMap.put("ProcessInstanceId",t.getProcessInstanceId());
		taskMap.put("ProcessName", t.getProcessDefinitionId().split(":")[0]);
		// Prepare the TaskAssignee, if there is an EmployeeID info associated with this user, then form the Assignee string to be in the format EmployeeID|UserName|GroupName. Note that the GroupName will be the group that he is assigned to this task because of being a member of it.
		taskMap.put("TaskAssignee",t.getAssignee());
		String employeeID = identityService.getUserInfo(t.getAssignee(), "employeeID");
//		logger.info(employeeID);
		if (employeeID != null && (!employeeID.equals("")))
		{
			taskMap.put("TaskAssigneeEmployeeID", employeeID);
		}
		//taskMap.put("TaskOwner",t.getOwner());			
		//taskMap.put("TaskPriority",String.valueOf(t.getPriority()));
		taskMap.put("DateFormat", "yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String cdate = format.format(t.getCreateTime());
		taskMap.put("TaskCreateTime",cdate);
		//Date dueDate = t.getDueDate();
		//if(dueDate!=null) {
		//	cdate = format.format(dueDate);
		//	taskMap.put("TaskDueDate",cdate);
		//}
		//DelegationState ds = t.getDelegationState();
		//if(t!=null) taskMap.put("TaskDelegationState",ds.name());
		String desc = t.getDescription();
		if(desc!=null && !desc.isEmpty()){
			StringTokenizer st = new StringTokenizer(desc,",");
			while(st.hasMoreTokens()){
				String token = st.nextToken();
				int equalIndex = token.indexOf("=");
				String pre = token.substring(0,equalIndex);
				String post = token.substring(equalIndex+1);
				taskMap.put(pre, post);
			}
		}
//		logger.info("BusinessProcessEngineActiviti.createTaskMap(): TaskMap: " + taskMap);
		return taskMap;
	}

	
	public List<Map<String,String>> listActiveTasks(String userId) {
		List<Task> allTasks = new ArrayList<Task>();
		
		
		GroupQuery Gq = identityService.createGroupQuery();
		Gq.groupMember(userId);
		List<Group> groups = Gq.list();
		
		TaskQuery tq = taskService.createTaskQuery();
		tq = tq.taskAssignee(userId);
		List<Task> tasks = tq.list();
		if(tasks!=null && tasks.size()>0)  allTasks.addAll(tasks);
		
		tq = taskService.createTaskQuery();
		tq.taskCandidateUser(userId);
		tasks = tq.list();
		if(tasks!=null && tasks.size()>0)  allTasks.addAll(tasks);
		
		if(groups!=null && groups.size()>0){
			for(Group g:groups){
				tq = taskService.createTaskQuery();
				tq.taskCandidateGroup(g.getName());
				tasks = tq.list();
				if(tasks!=null && tasks.size()>0)  allTasks.addAll(tasks);
			}
		}
		
		if(allTasks.size()==0) return null;
		
		List<Map<String,String>> tasksMaps = new ArrayList<Map<String,String>>();
		for(Task t: allTasks)
			tasksMaps.add(createTaskMap(t));
				
		return tasksMaps;
	}

	
	public List<Map<String,String>> listAvailableTasksForGroup(String groupId) {
		List<Task> allTasks = new ArrayList<Task>();
	
		TaskQuery tq = taskService.createTaskQuery();
		tq.taskCandidateGroup(groupId);
		List<Task> tasks = tq.list();
		if(tasks!=null && tasks.size()>0)  allTasks.addAll(tasks);
		
//		if(allTasks.size()==0) return null;
		
		List<Map<String,String>> tasksMaps = new ArrayList<Map<String,String>>();
		for(Task t: allTasks)
			tasksMaps.add(createTaskMap(t));

		return tasksMaps;
	}

	/**
	 * Most probably this is the one to be used to retrieve all the available tasks for any User.
	 * This is better covering for this use case than the above. Consider the user lies in more than one group. Using this method will guarantee that all the available tasks, regardless of they are assigned to which group, are returned.
	 * @param userId The user ID to retrieve all the tasks that this user ID is candidate in it, in other words, is able to claim it
	 * @return
	 */
	
	public List<Map<String,String>> listAvailableTasksForCandidate(String userId) {
		List<Task> allTasks = new ArrayList<Task>();
	
		TaskQuery tq = taskService.createTaskQuery();
		tq.taskCandidateUser(userId);
		List<Task> tasks = tq.list();
		if(tasks!=null && tasks.size()>0)  allTasks.addAll(tasks);
		
		List<Map<String,String>> tasksMaps = new ArrayList<Map<String,String>>();
		for(Task t: allTasks)
			tasksMaps.add(createTaskMap(t));
				
		return tasksMaps;
	}

	
	public List<Map<String,String>> listClaimedTasksForUser(String userId) {
		List<Task> allTasks = new ArrayList<Task>();
		
		TaskQuery tq = taskService.createTaskQuery();
		tq = tq.taskAssignee(userId);
		List<Task> tasks = tq.list();
		if(tasks!=null && tasks.size()>0)  allTasks.addAll(tasks);
		
		List<Map<String,String>> tasksMaps = new ArrayList<Map<String,String>>();
		for(Task t: allTasks)
			tasksMaps.add(createTaskMap(t));
				
		return tasksMaps;
	}
	
	public List<Map<String,String>> listPendingTasksOfProcess(String procId) {
		Set<Task> allTasks = new HashSet<Task>();
		listPendingTasksOfProcess(procId, allTasks);
		
		List<Map<String,String>> tasksMaps = new ArrayList<Map<String,String>>();
		for(Task t: allTasks)
			tasksMaps.add(createTaskMap(t));

		return tasksMaps;
	}
	
	
	private void listPendingTasksOfProcess(String procId, Set<Task> collectedTasks) {

		TaskQuery tq = taskService.createTaskQuery();
		tq.processInstanceId(procId);

		List<Task> tasks = tq.list();
		
		if(tasks!=null && tasks.size()>0)  collectedTasks.addAll(tasks);

		// Now check if the supplied Process Instance ID has any children processes
		// If so, recursively retrieve all the children tasks
		HistoricProcessInstanceQuery hp = historyService.createHistoricProcessInstanceQuery();
		hp.superProcessInstanceId(procId);
		hp.unfinished();
		List<HistoricProcessInstance> childrenProcshp = hp.list();
		for (HistoricProcessInstance proc : childrenProcshp)
			listPendingTasksOfProcess(proc.getId(), collectedTasks);
	}
	
	
	public List<String> getAllProcessIdsInitiatedByUser(String userId) {
		List<String> ids = new ArrayList<String>();
		
		HistoricProcessInstanceQuery tq = historyService.createHistoricProcessInstanceQuery();
		tq.startedBy(userId);
		List<HistoricProcessInstance> proces = tq.list();
	
		for (HistoricProcessInstance proc : proces)
			ids.add(proc.getId());
		
		// I only need the ultimate parents, so remove any children may have their parents in the same list
		return removeChildProcessFromFlatedProcesIDs(ids); 
	}
	
	
	public List<String> getFinishedProcessIdsInitiatedByUser(String userId) {
		List<String> ids = new ArrayList<String>();
		
		HistoricProcessInstanceQuery tq = historyService.createHistoricProcessInstanceQuery();
		tq.startedBy(userId);
		tq.finished();
		
		List<HistoricProcessInstance> proces = tq.list();
	
		for (HistoricProcessInstance proc : proces)
			ids.add(proc.getId());
		
		// I only need the ultimate parents, so remove any children may have their parents in the same list
		return removeChildProcessFromFlatedProcesIDs(ids); 
	}
	
	
	public List<String> getUnfinishedProcessIdsInitiatedByUser(String userId) {
		List<String> ids = new ArrayList<String>();
		
		HistoricProcessInstanceQuery tq = historyService.createHistoricProcessInstanceQuery();
		tq.startedBy(userId);
		tq.unfinished();
		
		
		List<HistoricProcessInstance> proces = tq.list();
	
		for (HistoricProcessInstance proc : proces)
			ids.add(proc.getId());
		

		// I only need the ultimate parents, so remove any children may have their parents in the same list
		return removeChildProcessFromFlatedProcesIDs(ids); 
	}
	
	/**
	 * This method searches a flated list containing list of different Process IDs, for any one of them being a child of another, returning only the ultimate parent process IDs
	 * In other words, this method removes any children processes which may have their parents in the same list 
	 * @param procesIDs
	 * @return
	 */
	private List<String> removeChildProcessFromFlatedProcesIDs(List<String> procesIDs){

		List<String> result = new ArrayList<String>(procesIDs);
		
		Set<String> toDel = new HashSet<String>();

		for (String procID : procesIDs){
			// Get the children of this process, add it to the collected IDs of child processes which should be deleted if they existed in the main ids list
			List<String> childrenToDel = getAllChildrenProcIdsOfParentProc(procID);
			toDel.addAll(childrenToDel);
		}

		result.removeAll(toDel);
		return result;
	}

	public List<String> getAllChildrenProcIdsOfParentProc(String procID){
		List<String> children = getAllChildrenProcIdsOfParentProcImpl(procID);
		
		// Remove the last element as it is the root we did already pass, as it gets added due to the previous recursion method
		children.remove(procID);
		return children;
	}
	
	private List<String> getAllChildrenProcIdsOfParentProcImpl(String procID){
		List<String> children = new ArrayList<String>();
		
		HistoricProcessInstanceQuery tq = historyService.createHistoricProcessInstanceQuery();
		tq.superProcessInstanceId(procID);
		
		List<HistoricProcessInstance> proces = tq.list();
		for (HistoricProcessInstance proc : proces)
			children.addAll(getAllChildrenProcIdsOfParentProcImpl(proc.getId()));
		
		// Add myself as well, so that in the recursion the leaf will be the first adding it self and returning a list containing it self
		children.add(procID);
		
		return children;
	}
	
	
	
	public Map<String,String> getActiveUserTask(String processInstanceId,String taskKey){
		TaskQuery tq = taskService.createTaskQuery();
		tq.taskDefinitionKeyLike(taskKey).processInstanceId(processInstanceId);
		Task t = tq.singleResult();
		if(t!=null){
			return createTaskMap(t);
		}else return null;
	}
	
	
	public List<String> listUserGroupIDs(String userId)
	{
		List<String> userGroupIDs = new ArrayList<String>();
		
		GroupQuery gq = identityService.createGroupQuery();
		gq.groupMember(userId);
		List<Group> groups = gq.list();
		
		for (Group group : groups)
			userGroupIDs.add(group.getId());
		return userGroupIDs;
	}
	
	
	public boolean checkPassword(String userId, String password) {
		
		return identityService.checkPassword(userId, password);
	}

	
	public void setAuthenticatedUserId(String userId) {
		identityService.setAuthenticatedUserId(userId);
	}
	
	
	public String getAuthenticatedUserId(String procesInstId) {
		return historyService.createHistoricProcessInstanceQuery().processInstanceId(procesInstId).singleResult().getStartUserId();
	}
	
	
	public void storeVar(String varName, Object VarVal) {
		vars.put(varName,VarVal);
		
	}

	
	public Object retrieveVar(String varName) {
		
		return vars.get(varName);
	}

	
	/**
	 * @param processDefinitionId
	 * @return InputStream of the process definition graph in PNG format 
	 * @throws Exception
	 */
	
	public byte[] getProcessDefinitionGraph(String processDefinitionId) throws Exception{
		

		
		byte[] byteArray = new byte[5];
		
		return byteArray;
	}
	
	
	public byte[] getProcessInstanceGraph(String processInstanceId, String diagramImageType) throws Exception{
		if (processInstanceId == null | processInstanceId.equals(""))
			throw new IllegalArgumentException("Invalid process instance ID.");
		
		ProcessInstanceQuery procQuery = processEngine.getRuntimeService().createProcessInstanceQuery();
		procQuery.processInstanceId(processInstanceId);
		ProcessInstance processinstance = procQuery.singleResult();
		
		if (processinstance == null)
			throw new Exception("Can't find a process instance with the supplied ID.");
		
		/* depricated after activiti 5.11
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) ((RepositoryServiceImpl) processEngine.getRepositoryService())
		        .getDeployedProcessDefinition(processinstance.getProcessDefinitionId());
		
		if (processDefinitionEntity == null)
			throw new Exception("Couldn't get the process definition for the process instance with the supplied ID.");
		//*/

		BpmnModel processDefinitionModel = (BpmnModel) ((RepositoryServiceImpl) processEngine.getRepositoryService()).getBpmnModel(processinstance.getProcessDefinitionId());
		if(processDefinitionModel== null)
			throw new Exception("Couldn't get the process definition for the process instance with the supplied ID.");
		
		List<String> activeActivitiesIds = processEngine.getRuntimeService().getActiveActivityIds(processInstanceId);
		
		InputStream imageInputStream = ProcessDiagramGenerator.generateDiagram(processDefinitionModel , diagramImageType, activeActivitiesIds);
		
		byte[] byteArray = new byte[5];
		
		return byteArray;
	}
	
	
	public void terminateProcessWith(String ProcessName, String varName, Object varValue, String reason){
        
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery().processDefinitionName(ProcessName).singleResult();
		if(pd==null) return;// TODO logging
		List<ProcessInstance> piList = runtimeService.createProcessInstanceQuery().processDefinitionId(pd.getId()).variableValueEquals(varName, varValue).list();
		if(piList!=null && !piList.isEmpty()){
			for(ProcessInstance pi : piList){
//				logger.info("!!!!!!    The Business Process Instance with [ name = "+ pi.getProcessDefinitionId() + " ] and [ id = "+ pi.getProcessInstanceId() +" ] and variable [ "+varName+" = "+varValue+" ], is being terminated because of [ "+reason+" ]");
				runtimeService.deleteProcessInstance(pi.getProcessInstanceId(), reason);
			}
		}
	}
	
	public void executeJob(){
		JobQuery jq = managementService.createJobQuery().orderByJobId().asc();//duedateHigherThan(dueDate.toDate());
		List<Job> jobs = jq.list();
		if(jobs!=null && !jobs.isEmpty()) managementService.executeJob(jobs.get(jobs.size()-1).getId());
	}
	
	
	public void deleteProcessInstance(String processInstanceId, String deleteReason){
		runtimeService.deleteProcessInstance(processInstanceId, deleteReason);	
	}
	
	
	public void deleteAllProcessInstances(){
		List<ProcessInstance> instances = runtimeService.createProcessInstanceQuery().list();
		for (ProcessInstance instance : instances){
			deleteProcessInstance(instance.getProcessInstanceId(), null);				
		}
	}
	
	public ProcessEngine getEngine() {
		return this.processEngine;
	}
}
