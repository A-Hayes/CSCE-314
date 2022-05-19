; Isabel Ramirez & Asa Hayes
; 28 Aug 2020
; CSCE-314-502
; Lab 1, Question 2: determines is input is even/odd or a nubmer at all  

(define (even-odd x)
  (if (number? x)
    (if (= (fxmodulo x 2) 0) ; checks if is a number
	    (+ 0 0) ; if true x is even
	    (+ 0 1) ; else x is odd
	  )
    (+ 0 2) ; not a number
  )
)

(define (main)
  (define z (even-odd(read)))
  (cond
   [(= z 0) (display "even")]
   [(= z 1) (display "odd")]
   [(= z 2) (display "not a number")]
  )
)

(main)
(exit)
