package org.UPSkiller.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class InternalAuthFilter extends OncePerRequestFilter {

    @Value("${internal.service.key}")
    private String expectedInternalKey;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String internalKey = request.getHeader("X-INTERNAL-KEY");
        String userId = request.getHeader("X-User-Id");

        if(internalKey == null || !internalKey.equals(expectedInternalKey)){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid internal access");
            return;
        }
        if(userId == null || userId.isBlank()){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Missing user identity");
            return;
        }
        filterChain.doFilter(request,response);



    }
}
