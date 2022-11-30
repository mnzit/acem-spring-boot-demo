package com.acem.demo.request.mapper;

import com.acem.demo.entity.Subject;
import com.acem.demo.request.SubjectSaveRequest;
import com.acem.demo.request.SubjectUpdateRequest;
import com.acem.demo.utils.ModelMapperUtil;

public class SubjectMapperUtil {
        public static Subject mapSubject(SubjectSaveRequest subjectSaveRequest) {
            return ModelMapperUtil.map(subjectSaveRequest, Subject.class);
        }

        public static Subject mapSubject(SubjectUpdateRequest subjectUpdateRequest) {
            return ModelMapperUtil.map(subjectUpdateRequest, Subject.class);
        }
}
