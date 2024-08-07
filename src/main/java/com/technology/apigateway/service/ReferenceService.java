package com.technology.apigateway.service;

import com.technology.apigateway.controller.request.references.ReferenceRequest;
import com.technology.apigateway.controller.request.references.UpdateReferenceRequest;
import com.technology.apigateway.database.entity.CustomerStatus;
import com.technology.apigateway.database.entity.ReferencesEntity;

public interface ReferenceService {

    CustomerStatus createReference(ReferenceRequest referenceRequest);

    CustomerStatus updateReference(UpdateReferenceRequest updateReferenceRequest);

    ReferencesEntity deleteReferencesById(int id);
}
