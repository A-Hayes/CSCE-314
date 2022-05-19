; Asa Hayes & Isabel Ramirez
; CSCE-314-502
; 4 Sep 2020
; Lab 2, Q1: Use function is-positive to tell if input is positive (0-incl) or not

(define (is-positive x)
  (if (>= x 0) #t #f)
)

(define (main)
  (display  (is-positive -100) )
  (newline)
  (display  (is-positive 0) )
  (newline)
  (display  (is-positive 100) )
  (newline)
)

(main)
(exit)