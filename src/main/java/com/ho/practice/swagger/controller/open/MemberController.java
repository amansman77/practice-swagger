package com.ho.practice.swagger.controller.open;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ho.practice.swagger.Member;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="onlinestore",
	tags = {"Member"}	// 컨트롤러를 그룹으로 표현
)
@RestController
@RequestMapping("/open")
public class MemberController {

	private Map<String, Member> memberMap = new HashMap<>();
	
	@PostMapping(value = "/member")
    public String addMember(@RequestBody Member person) {
		memberMap.put(person.getId(), person);
        return "success";
    }
	
	@ApiOperation(value = "회원 조회", notes = "회원정보를 조회하고 검색합니다.")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "remoteAddr1", value = "원격 주소1", defaultValue = ""),
		@ApiImplicitParam(name = "remoteAddr2", value = "원격 주소2", defaultValue = "", required = true),
		@ApiImplicitParam(name = "remoteAddr3", value = "원격 주소3", defaultValue = "", required = false),
		@ApiImplicitParam(name = "id", value = "회원 아이디", defaultValue = ""),
		@ApiImplicitParam(name = "q", value = "검색 쿼리", defaultValue = ""),
		@ApiImplicitParam(name = "offset", value = "결과 오프셋", defaultValue = ""),
		@ApiImplicitParam(name = "limit", value = "결과 조회수", defaultValue = "")
	})
	@GetMapping(value = "/member/{id}")
    public Member getMember(
    		@RequestHeader String remoteAddr1,
    		@RequestHeader(required = true) String remoteAddr2,
    		@RequestHeader(required = false) String remoteAddr3,
    		@PathVariable String id,
    		@RequestParam(value = "q", required = false) String query,
    		@RequestParam(required = false) String offset,
    		@RequestParam(required = false) String limit) {
        return memberMap.get(id);
    }
	
	/**
	 * 회원을 검색한다.
	 * @param query
	 * @param offset
	 * @param limit
	 * @return
	 */
	@GetMapping(value = "/member")
    public Member getMember(
    		@RequestParam(value = "q", required = false) String query,
    		@RequestParam(required = false) String offset,
    		@RequestParam(required = false) String limit) {
        return new Member();
    }
	
	/**
	 * 회원을 검색한다.
	 * @param query
	 * @param offset
	 * @param limit
	 * @return
	 */
	@Deprecated
	@GetMapping(value = "/member/legacy")
    public Member getMemberLegacy(
    		@RequestParam(value = "q", required = false) String query,
    		@RequestParam(required = false) String offset,
    		@RequestParam(required = false) String limit) {
        return new Member();
    }
	
	@PutMapping(value = "/member/{id}")
    public String updateMember(@PathVariable String id, @RequestBody Member person) {
		memberMap.put(id, person);
        return "success";
    }

	@DeleteMapping(value = "/member/{id}")
    public String deleteMember(@PathVariable String id) {
		memberMap.remove(id);
        return "success";
    }
	
	@GetMapping(value = "/hidden/member")
    public Member getHiddenMember(@PathVariable String id) {
        return memberMap.get(id);
    }
}
