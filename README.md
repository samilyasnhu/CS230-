## Client Summary and Software Requirements

The client for this project was **The Gaming Room**, a company seeking to expand their existing Android-based game, *Draw It or Lose It*, to support multiple operating platforms. The game is a multiplayer, web-based application inspired by the television game *Win, Lose or Draw*, where teams guess images that are progressively rendered on the screen. The client required a scalable, distributed solution capable of supporting multiple simultaneous game instances, each with unique teams and players. Key requirements included platform independence, secure user authentication, role-based authorization, efficient memory and storage management, and the ability to scale to thousands of concurrent users.

## Strengths in Developing the Documentation

One area I performed particularly well was clearly documenting the **architectural decisions**, especially the use of the client-server pattern and RESTful APIs. I effectively explained how separating the server-side logic from the client-side interfaces allows the application to scale across multiple platforms while maintaining a single source of truth for game logic and data. I also did well in identifying and documenting security requirements, such as authentication and authorization, and aligning them with industry best practices.

## Value of the Design Document Process

Working through the design document before implementing code was extremely helpful. It forced me to think through system requirements, constraints, and interactions before writing any implementation details. This reduced rework during coding and made it easier to identify potential issues related to scalability, security, and performance early in the process. The design document also served as a roadmap, ensuring that development stayed aligned with the client’s needs and expectations.

## Areas for Improvement

If I could revise one part of my documentation, I would improve the **initial platform comparison and cost analysis**. While I identified the advantages of cloud-based platforms, I would expand this section to include more concrete cost scenarios and performance trade-offs. Adding diagrams or more quantitative comparisons would further strengthen the clarity and usefulness of this section for stakeholders making deployment decisions.

## Interpreting and Implementing User Needs

I interpreted the user’s needs by focusing on scalability, accessibility, and performance. Since *Draw It or Lose It* is a real-time multiplayer game, I prioritized low-latency communication, efficient memory usage for image rendering, and a design that supports multiple concurrent sessions. Considering user needs is critical because software that does not align with how users interact with it—especially in a game—will fail regardless of how well it is engineered. Designing with the user in mind ensures better usability, engagement, and long-term success.

## Design Approach and Future Strategies

My approach to designing the software involved breaking the system into modular components, identifying clear responsibilities for each layer, and using standard design patterns such as client-server architecture and REST APIs. In the future, I would continue to use techniques such as requirements analysis, UML diagrams, and iterative prototyping to design similar applications. I would also place greater emphasis on early performance testing and cloud-native design principles, such as stateless services and managed infrastructure, to further improve scalability and maintainability.