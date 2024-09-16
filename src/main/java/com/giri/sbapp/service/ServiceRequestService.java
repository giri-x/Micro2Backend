package com.giri.sbapp.service;

import java.util.List;

import com.giri.sbapp.model.ServiceRequest;

public interface ServiceRequestService {
	
	    ServiceRequest createServiceRequest(ServiceRequest serviceRequest);
	    ServiceRequest approveServiceRequest(Long id);
	    List<ServiceRequest> getRequestsByAcUnitId(Long acUnitId);
	    List<ServiceRequest> getAllServiceRequests();
	    ServiceRequest getRequestByAcUnitIdAndRequestId(Long acUnitId, Long requestId);

}
