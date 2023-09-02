package com.webnorm.prototypever1.security.service;

import com.webnorm.prototypever1.entity.Member;
import com.webnorm.prototypever1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    // authenticate() 실행시 이 메서드 실행 : username 으로 사용자 찾아서 인증
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> findMember = memberRepository.findByEmail(username);
        if (findMember.isPresent()) {
            UserDetails userDetails = createUserDetails(findMember.get());
            log.info(userDetails.getUsername() + " " + userDetails.getPassword() + " " + userDetails.getAuthorities());
            return userDetails;
        }
        else
            throw new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다.");
    }

    // userDetail 객체 생성해주는 메서드 -> 해당하는 사용자의 데이터가 존재하면 userDetails 객체로 만들어 리턴
    public UserDetails createUserDetails(Member member) {
        return User.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .roles(member.getRoles().toArray(new String[0]))
                .build();
    }
}