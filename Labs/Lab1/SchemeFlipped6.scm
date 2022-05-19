; Isabel Ramirez & Asa Hayes
; 28 Aug 2020
; CSCE-314-502
; Lab 1, Question 6: curved grade calculator

(define (CurvedGrade x lambdafunction)
  (lambdafunction x)
)

(define (main)
  (display (CurvedGrade (read) (lambda (x) (* x 1.2))))
  (newline)
  (display (CurvedGrade (read) (lambda (x) (+ x 5))))
  (newline)
)

(main)
(exit)
