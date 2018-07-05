package com.renjie.domain.bizs;

import com.renjie.entity.Role;
import lombok.Data;

import java.util.List;

@Data
public class RoleBiz extends Role {

    private List<AuthorityBiz> authorityBizList;
}
