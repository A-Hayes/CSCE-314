; Isabel Ramirez & Asa Hayes
; 28 Aug 2020
; CSCE-314-502
; Lab 1, Question 3: calculate 15% of some amount

(define (fifteen-percent x)
  (* x 0.15)
)

(define (main)
  (display (fifteen-percent (read)))
  (newline)
  (display (fifteen-percent (read)))
  (newline)
)

(main)
